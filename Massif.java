package com.intexsoft.bashko.anastasiya;

import java.util.Scanner;
import java.util.Arrays;

public class Massif {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		// Task 1 M���� ��������
		int[] arr = { 1, 8, 10, 5, 9, 6, 3, 4, 2 };
		for (int j = arr.length - 1; j >= 0; j--) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int a = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = a;
				}
			}
		}

		System.out.print("������� 1: ���������� ������� ������� ��������: ");
		getPrintArray(arr);

		// Task 2
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James",
				"Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };
		for (int j = times.length - 1; j > 0; j--) {
			for (int i = 0; i < times.length - 1; i++) {
				if (times[i] > times[i + 1]) {
					int el_time = times[i];
					times[i] = times[i + 1];
					times[i + 1] = el_time;
					String el_name = names[i];
					names[i] = names[i + 1];
					names[i + 1] = el_name;
				}
			}
		}
		System.out.println("������� 2: ���������� ���������� �� ����������");
		getPrintArray(names);
		getPrintArray(times);

		// Task3. ����������� �����, � ������ �� ��� ��������.
		int z = 0;
		System.out.print("������� �����: ");
		z = scan.nextInt();
		char[] array1 = Integer.toString(z).toCharArray();
		int[] array2 = new int[array1.length];
		for (int i = 0; i < array1.length - 1; i++) {
			array2[i] = Character.getNumericValue(array1[i]);
		}
		System.out.println("������� 3: ����������� �����, � ������");
		getPrintArray(array1);

		// Task4. ��������� �����
		int a = findElemInArray(6, arr);
		System.out.println("������� 4: �������� ����� ��������  � ��������������� �������: ");
		System.out.println(a);
	}

	private static void getPrintArray(int[] a) {
		String array_print = Arrays.toString(a);
		System.out.println(array_print);
	}

	private static void getPrintArray(char[] a) {
		String array_print = Arrays.toString(a);
		System.out.println(array_print);
	}

	private static void getPrintArray(String[] a) {
		String array_print = Arrays.toString(a);
		System.out.println(array_print);
	}

	public static int findElemInArray(int x, int[] a) {
		int i = -1;
		if (a != null) {
			int low = 0, high = a.length, mid;
			while (low < high) {
				mid = (low + high) / 2;
				if (x == a[mid]) {
					i = mid;
					break;
				} else {
					if (x <= a[mid]) {
						high = mid;
					} else {
						low = mid + 1;
					}
				}
			}
		}
		return i;
	}
}
