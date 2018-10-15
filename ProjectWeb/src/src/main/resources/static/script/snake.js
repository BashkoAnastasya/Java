var Snake = {	
		config: {
			pitchID: "snake",
			rowID: "row", // input для задания столбцов
			collumID:"collum",  // input для задания строк
			freeBrick: "<b></b>",//свободная ячейка
			filledBrick: "<i></i>", //занятая ячейка едой
			filledBrickSnake: "<s></s>", //занятая ячейка змейкой
			lineSeparator: "<br>"
		},

		pitch: {
			width: 6,
			height: 6,
			bricks: [],
			getDom: function() {
				return document.getElementById(Snake.config.pitchID);
			}
		},

		startBtn: document.getElementById('start-btn'),	

		hangrySnake: {
			coords: [],
			create: function() {
				this.coords = [[0,0]];
			},

			//движение хвоста
			tailStep: function(){
				if (Snake.hangrySnake.coords.length>1) {
					for (var i=Snake.hangrySnake.coords.length-1;  i>0; i--){
						Snake.hangrySnake.coords[i]=Snake.hangrySnake.coords[i-1].slice();
					}
				}	
			},

			sideStep: function(direction) {
				Snake.hangrySnake.tailStep();
				if (direction == 'right') {	
					Snake.hangrySnake.coords[0][1]++;					
				} else if (direction == 'left') {
					Snake.hangrySnake.coords[0][1]--;
				} else if (direction == 'up') {
					Snake.hangrySnake.coords[0][0]--;
				}	else{
					Snake.hangrySnake.coords[0][0]++;
				}
			},
			eatFood: function() {
				if ((Snake.hangrySnake.coords[0][0]==Snake.food.coords[0]) && (Snake.hangrySnake.coords[0][1]==Snake.food.coords[1])){
					Snake.hangrySnake.coords.push(Snake.food.coords);
					Snake.food.create();
				}
			}

		},

		food : {
			coords: [],
			create: function() {
				this.coords = [Math.floor(Math.random() * Snake.pitch.height), Math.floor(Math.random() * Snake.pitch.width)];
				//this.coords =[1,0];
			}
		},	

		init: function() {

			Snake.pitch.width = document.getElementById(Snake.config.rowID).value;
			Snake.pitch.height = document.getElementById(Snake.config.collumID).value;
			document.getElementById(Snake.config.rowID).onclick = function () {
				Snake.pitch.width = document.getElementById(Snake.config.rowID).value;
				document.getElementById(Snake.config.pitchID).style.width =Snake.pitch.width*24 + "px";
				for (var i = 0; i < Snake.pitch.height; i++) {
					Snake.pitch.bricks[i] = [];
					for (var j = 0; j < Snake.pitch.width; j++) {
						Snake.pitch.bricks[i][j] = 0;
					}
				}	
			}

			document.getElementById(Snake.config.collumID).onclick = function () {
				Snake.pitch.height = document.getElementById(Snake.config.collumID).value;
				document.getElementById(Snake.config.pitchID).style.height =Snake.pitch.height*24 + "px";
				for (var i = 0; i < Snake.pitch.height; i++) {
					Snake.pitch.bricks[i] = [];
					for (var j = 0; j < Snake.pitch.width; j++) {
						Snake.pitch.bricks[i][j] = 0;
					}
				}	
			}


			for (var i = 0; i < Snake.pitch.height; i++) {
				Snake.pitch.bricks[i] = [];
				for (var j = 0; j < Snake.pitch.width; j++) {
					Snake.pitch.bricks[i][j] = 0;
				}
			}	

			Snake.startBtn.onclick = function () {
				Snake.tick();
			}
		},

//		пренадлежит ли змейке ячейка		
		find: function(i,j,k) {
			for (var h= k; h < Snake.hangrySnake.coords.length; h++) {			    
				if (Snake.hangrySnake.coords[h][0] == i && Snake.hangrySnake.coords[h][1] == j){
					return true; 
				}

			}
		},

		//отрисовка поля
		draw: function() {
			var snakeDom = Snake.pitch.getDom();
			snakeDom.innerHTML = '';
//			пробежимся по массиву кирпичиков
			for (var i = 0; i < Snake.pitch.bricks.length; i++) {
				for (var j = 0; j < Snake.pitch.bricks[i].length; j++) {				
					if (// ИЛИ есть ли по этим координатам еда или змея 
							(Snake.food.coords[0] == i   &&
									Snake.food.coords[1] == j ) || (Snake.find(i,j,0)) ){
						snakeDom.innerHTML += Snake.config.filledBrick;
					} else {
						snakeDom.innerHTML += Snake.config.freeBrick;
					}	
				}
				snakeDom.innerHTML += Snake.config.lineSeparator;
			}
		},

		each: function(coords, collback){
			for (var i=0; i<coords.lenght;i++){
				for (var j=0; j<coods[i].lenght; j++){

				}
			}	
		},

		checkGameOver: function() {
			// Если на момент проверки выход за границы - Game over
			if ((Snake.hangrySnake.coords[0][0] >= Snake.pitch.height)
					||(Snake.hangrySnake.coords[0][0] < 0) 
					|| (Snake.hangrySnake.coords[0][1] >=Snake.pitch.width) 
					|| (Snake.hangrySnake.coords[0][1] < 0) ||  (Snake.find(Snake.hangrySnake.coords[0][0],Snake.hangrySnake.coords[0][1],1))) {
				alert('Game over');
				clearInterval(Snake.tickHandler);
			} else {
				return false;
			}
		},

		tick: function() {

			//Создание еды
			if (Snake.food.coords.length == 0) {
				Snake.food.create();
			}

			//Создание змейки
			if (Snake.hangrySnake.coords.length == 0) {
				Snake.hangrySnake.create();
			}

			window.onkeydown = function (event) {				
				if (event.keyCode == 39) {
					Snake.direction = 'right';
				} else if(event.keyCode == 37) {
					Snake.direction = 'left';
				}  else if(event.keyCode == 38) {
					Snake.direction = 'up';
				}  else if(event.keyCode == 40) {
					Snake.direction = 'down';
				}					
			}

			Snake.hangrySnake.eatFood();
			Snake.hangrySnake.sideStep(Snake.direction);
			Snake.checkGameOver();
			// Отрисовка поля
			Snake.draw();

			//Для завершения игры
			if (Snake.tickHandler === undefined) {				
				Snake.tickHandler  = setInterval(function(){
					Snake.tick();
				}, 500);
			}
		},
};

Snake.init();