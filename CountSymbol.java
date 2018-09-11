package com.intexsoft.bashko.anastasiya;

import java.util.Scanner;
import java.math.*;
import java.util.Arrays;

public class CountSymbol {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("¬ведите строку");
		String str = scan.next();
		char[] array = str.toCharArray();
		char[] symbol = new char[array.length+1];
		int [] count = new int[array.length+1];
		int j = 0;		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != symbol[j]) {
				j = j + 1;
				symbol[j] = array[i];
				count[j] = 1;
			} else {
				count[j] = count[j] + 1;
			}
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				System.out.print(String.valueOf(symbol[i]) + "-" + count[i] + " ");
			}
		}

	}

}
