package com.intexsoft.bashko.anastasiya;

import java.util.Scanner;
import java.math.*;
import java.util.Arrays;

public class CountSymbol {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter string");
		String str = scan.next();	
		char[] symbol = new char[str.length()+1];
		int [] count = new int[str.length()+1];
		int j = 0;		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != symbol[j]) {
				j +=  1;
				symbol[j] = str.charAt(i);
				count[j] = 1;
			} else {
				count[j] += 1;
			}
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				System.out.print(String.valueOf(symbol[i]) + "-" + count[i] + " ");
			}
		}

	}

}
