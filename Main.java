package pkg_point_area;

import java.util.Scanner;
import java.math.*;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		double point_x = getdouble();
		double point_y = getdouble();

		double sTriangle = squareTriangle(0, 0, 0, 1, 1, 0);

		// Введенной точкой делим треугольник на три треугольника
		double sTriangle_1 = squareTriangle(point_x, point_y, 0, 1, 1, 0);
		double sTriangle_2 = squareTriangle(0, 0, point_x, point_y, 1, 0);
		double sTriangle_3 = squareTriangle(0, 0, 0, 1, point_x, point_y);
		// Если сумма площедей тругольников равна площади исходного треугольника то
		// точка входит в область
		if (sTriangle == (sTriangle_1 + sTriangle_2 + sTriangle_3)) {
			System.out.print("Точка входит в область:");
		} else {
			System.out.print("Точка не входит в область:");
		}

	}

	public static double getdouble() {
		System.out.print("Введите координаты точки:");
		double num;
		if (scan.hasNextDouble()) {
			num = scan.nextDouble();
		} else {
			System.out.print("Введены не кооректные данные. Попробуйде еще раз");
			scan.next();
			num = getdouble();
		}
		return num;
	}

	// В метод передаем координаты точки и получаем площадь треугольника
	public static double squareTriangle(double x_1, double y_1, double x_2, double y_2, double x_3, double y_3) {
		double square = Math.abs(((x_1 - x_3) * (y_2 - y_3) - (x_2 - x_3) * (y_1 - y_3)) * 0.5);
		System.out.println(square);
		return square;
	}

}
