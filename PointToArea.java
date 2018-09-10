package com.intexsoft.bashko.anastasiya;

import java.util.Scanner;
import java.math.*;
import java.util.Arrays;

public class PointToArea {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		double point_x = getDouble();
		double point_y = getDouble();

		if (point_x < 1 & point_x > 0 & point_x < Math.sqrt(point_y + 1) & point_y > 0 & point_y < 1
				& point_y < (point_x - 1) * (point_x - 1)) {
			System.out.println("����� ������ � �������");
		} else {
			System.out.println("����� �� ������ � �������");
		}
	}

	public static double getDouble() {
		System.out.print("������� ���������� �����:");
		double num;
		if (scan.hasNextDouble()) {
			num = scan.nextDouble();
		} else {
			System.out.println("������� �� ���������� ������. ���������� ��� ���");
			scan.next();
			num = getDouble();
		}
		return num;
	}

}
