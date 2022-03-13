package com.example.demo.service;

public class checkInputYearUruudoshi {

	public String checkInputYear(int year) {

		String s = "";

		if (year % 400 == 0) {
			System.out.println(year + "年は閏年です。");
			s = year + "年は閏年です。";
		} else if (year % 100 == 0) {
			System.out.println(year + "年は閏年ではありません。");
			s = year + "年は閏年ではありません。";
		} else if (year % 4 == 0) {
			System.out.println(year + "年は閏年です。");
			s = year + "年は閏年です。";
		} else {
			System.out.println(year + "年は閏年ではありません。");
			s = year + "年は閏年ではありません。";
		}

		return s;
	}
}
