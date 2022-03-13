package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UruudoshiService {
	public List<String> getUruudhosiList() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		int year = Integer.parseInt(sdf.format(now));
		List<String> list = new ArrayList<>();

		System.out.println("now year is " + year);
		String s = "今年は" + year + "年です。";
		list.add(s);

		while (year >= 0) {
			if (year % 400 == 0) {
				System.out.println(year + " nen is uruudoshi!");
				s = year + "年は閏年です。";
				list.add(s);
			} else if (year % 100 == 0) {
				System.out.println(year + " nen is not uruudoshi!");
				s = year + "年は閏年ではありません。";
				list.add(s);
			} else if (year % 4 == 0) {
				System.out.println(year + " nen is uruudoshi!");
				s = year + "年は閏年です。";
				list.add(s);
			} else {
				System.out.println(year + " nen is not uruudoshi!");
				s = year + "年は閏年ではありません。";
				list.add(s);
			}
			year -= 1;
		}
		return list;
	}
}
