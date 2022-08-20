package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 名前
	 */
	@NotEmpty(message = "名前を入力してください")
	@Size(max = 100, message = "名前は100桁以内で入力してください")
	private String name;

	/**
	 * パスワード
	 */
	@NotEmpty(message = "パスワードを入力してください")
	@Size(max = 255, message = "パスワードは255桁以内で入力してください")
	private String password;

	/**
	 * ロール
	 */
	@NotEmpty(message = "ロールを選択してください")
	@Size(max = 2)
	private String role;

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	/**
	 * ユーザーID
	 */
	@NotNull
	private Long id;

	public void setId(Long userId) {
		this.id = userId;

	}

	public void setName(String userName) {
		this.name = userName;

	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

}