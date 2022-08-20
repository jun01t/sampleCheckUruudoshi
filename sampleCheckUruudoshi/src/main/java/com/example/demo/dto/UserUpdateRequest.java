package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateRequest extends UserRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ユーザーID
	 */
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long userId) {
		this.id = userId;

	}
}