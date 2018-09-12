package com.intexsoft.bashko.comporator;

import com.intexsoft.bashko.anastasiya.Number;
import java.util.Comparator;

public class NumberComporator implements Comparator<Number> {

	
	public int compare (Number number1, Number number2) {
		      
	        if(number1.getnumber()> number2.getnumber())
	            return 1;
	        else if(number1.getnumber()< number2.getnumber())
	            return -1;
	        else
	            return 0;
	    }		
	}


