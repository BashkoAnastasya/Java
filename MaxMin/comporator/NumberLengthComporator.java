package com.intexsoft.bashko.comporator;

import com.intexsoft.bashko.anastasiya.Number;
import java.util.Comparator;

public class NumberLengthComporator implements Comparator<Number> {

	
	public int compare (Number number1, Number number2) {
		return Integer.compare(number2.getLength(), number1.getLength());			
	}

}
