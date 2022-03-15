package com.example.demo.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class Form1 {

	@Pattern(regexp = "^[0-9]+$", message = "数値を入力してください")
	@Length(max = 5, min = 1)
	private String year;

	public String getYear() {
		return year;
	}

	public void setYear(String id2) {
		this.year = id2;
	}
}
