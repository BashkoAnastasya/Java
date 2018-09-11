package com.intexsoft.bashko.anastasiya;

import java.util.Scanner;
import java.math.*;
import java.util.Arrays;

public class SpiralMatrix {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Введите количество строк");
		int countRow = scan.nextInt();
		System.out.println("Введите количество столбцов");
		int countColum = scan.nextInt();
		int temp = 1;
		int[][] matrix = new int[countRow][countColum];
		int vit = Math.round(countRow / 2);

		for (int k = 0; k <= vit; k++) {
			// right
			for (int j = k; j < countColum - k; j++) {
				matrix[k][j] = temp;
				temp++;
			}
			// down
			for (int i = k + 1; i <= countRow - k - 1; i++) {
				matrix[i][countColum - k - 1] = temp;
				temp++;
			}
			// left
			for (int z = countColum - k - 2; z > k; z--) {
				matrix[countRow - k - 1][z] = temp;
				temp++;
			}
			// up
			for (int l = countRow - k - 1; l > k; l--) {
				matrix[l][k] = temp;
				temp++;
			}
		}

		for (int i = 0; i < matrix.length; i++, System.out.println()) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}
}
