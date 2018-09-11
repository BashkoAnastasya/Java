package com.intexsoft.bashko.anastasiya;

import java.util.Scanner;
import java.math.*;
import java.util.Arrays;

public class SquareArrays {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Ââåäèòå ðàçìåðíîñòü êâàäðàòíîé ìàòðèöû: ");
		int rang = scan.nextInt();
		int[][] squareArrays = new int[rang][rang];
		int k = Math.round(rang / 2);

		for (int d = 0; d <= k; d++) {
			for (int i = d; i < squareArrays.length - d; i++) {
				for (int j = d; j < squareArrays[i].length - d; j++) {
					squareArrays[i][j] = d + 1;
				}
			}
		}

		for (int i = 0; i < squareArrays.length; i++, System.out.println()) {
			for (int j = 0; j < squareArrays[i].length; j++) {
				System.out.print(squareArrays[i][j] + " ");
			}
		}
	}
}
