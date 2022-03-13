package com.example.demo.service;

public class checkInputYearUruudoshi {

	public String checkInputYear(int year) {

		String s = "";

		try {
			if (checkInput(year) == false) {
				System.out.println("4桁の数値を入力してください。");
				s = "4桁の数値を入力してください。";
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

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

	private static boolean checkInput(int input) {

		if (input > 9999) {
			return false;
		} else {
			return true;
		}
	}

}
