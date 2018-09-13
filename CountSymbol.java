package com.intexsoft.bashko.anastasiya;

public class CountSymbol {

	public static void main(String[] args) {
		String str = "strstrstrstrstrbbbbbbstrstrstrstrccccccccccd";
		str = str + " ";
		String strnew = "";
		int count = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) != str.charAt(i + 1)) {
				strnew = strnew + str.charAt(i) + count;
				count = 1;
			} else {
				count++;
			}
		}
		System.out.println(strnew);
	}
}
