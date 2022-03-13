package com.example.demo.form;

import javax.validation.constraints.Pattern;

public class Form1 {

	@Pattern(regexp = "^[0-9]+$", message = "数値を入力してください")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id2) {
		this.id = id2;
	}
}
