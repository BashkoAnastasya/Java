package com.intexsoft.bashko.anastasiya;

import java.util.Scanner;
import java.math.*;
import java.util.Arrays;

public class SquareArrays2 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("¬ведите размерность квадратной матрицы: ");
		int rang = scan.nextInt();
		int[][] squareArrays = new int[rang][rang];
		int k = Math.round(rang / 2);

		for (int i = k; i < squareArrays.length; i++) {
			for (int j = k; j < squareArrays.length; j++) {
				squareArrays[i][j] = rang - Math.max(i, j);
				squareArrays[i][(rang - 1) - j] = squareArrays[i][j];
				squareArrays[(rang - 1) - i][j] = squareArrays[i][j];
				squareArrays[(rang - 1) - i][(rang - 1) - j] = squareArrays[i][j];
			}
		}

		for (int i = 0; i < squareArrays.length; i++, System.out.println()) {
			for (int j = 0; j < squareArrays[i].length; j++) {
				System.out.print(squareArrays[i][j] + " ");
			}
		}

	}

}
