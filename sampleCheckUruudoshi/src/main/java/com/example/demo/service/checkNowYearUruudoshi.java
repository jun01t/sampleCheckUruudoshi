package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class checkNowYearUruudoshi {

	public String getNowYearUruudoshi() {
		// TODO 自動生成されたメソッド・スタブ
		Date now = new Date();
		String s = "";

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		int year = Integer.parseInt(sdf.format(now));

		if (year % 400 == 0) {
			System.out.println(year + "年は閏年です。");
			s = year + "年は閏年です";
		} else if (year % 100 == 0) {
			System.out.println(year + "年は閏年ではありません。");
			s = year + "年は閏年ではありません。";
		} else if (year % 4 == 0) {
			System.out.println(year + "年は閏年です。");
			s = year + "年は閏年です。";
		} else {
			System.out.println(year + "年は閏年ではありません");
			s = year + "年は閏年ではありません。";
		}
		return s;
	}
}
