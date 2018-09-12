package com.intexsoft.bashko.anastasiya;

import com.intexsoft.bashko.comporator.*;

import com.intexsoft.bashko.anastasiya.Number;
import java.util.Scanner;
import java.util.TreeSet;

public class MaxMinNumber {
	static Scanner scan = new Scanner(System.in);
	// Find the shortest and longest number. Output the found numbers and their
	// length.
	// Sort and display numbers in ascending or descending order of their values
	// length.

	public static void main(String[] args) {
		
		TreeSet<Number> numbers = new TreeSet<Number>(
				new NumberLengthComporator().thenComparing(new NumberComporator()));
		System.out.println("¬ведите количество чисел");
		int n = scan.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print("¬ведите число");
			int number = scan.nextInt();
			String str = Integer.toString(number);
			int length = str.length();
			numbers.add(new Number(number, length));
		}

		for (Number number : numbers) {
			System.out.printf("Element %s lenght %s; ", number.getnumber(), number.getLength());
		}
		System.out.println();

		System.out.printf("MAX length number: %s length %s; MIN length number: %s length %s ",
				numbers.last().getnumber(), numbers.last().getLength(), numbers.first().getnumber(),
				numbers.first().getLength());

	}
}
