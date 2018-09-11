package com.intexsoft.bashko.anastasiya;

import java.util.Scanner;
import java.math.*;
import java.util.Arrays;

public class OverturnNumber {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("¬ведите число");
		int number = scan.nextInt();
		String str = String.valueOf(number);
		String newstr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			newstr = newstr + str.charAt(i);
		}
		number = Integer.parseInt(newstr);
	}
}
