package com.example.demo.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class Form1 {

	@Pattern(regexp = "^[0-9]+$", message = "数値を入力してください")
	@Length(max = 5, min = 1)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id2) {
		this.id = id2;
	}
}
