
		function getParentNode(oThis, sNodeName) {
			while (oThis.nodeName != sNodeName && oThis.nodeName != 'BODY') {
				oThis = oThis.parentNode;
			}
			return oThis.nodeName != 'BODY' ? oThis : null;
		}

		function Status(obj,intex,link) {
			var tr = getParentNode(obj, 'TR');			
			if (tr.cells[intex].innerHTML == 'Актуальный') {
				alert('Cannot change the current document')
			}
			else{
				document.location.href =link +tr.cells[0].innerHTML;
			}
		}	
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		