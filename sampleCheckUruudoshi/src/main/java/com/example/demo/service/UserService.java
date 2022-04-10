package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.LoginUser;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * ユーザー情報 全検索
	 * 
	 * @return 検索結果
	 */
	public List<LoginUser> searchAll() {
		return userRepository.findAll();
	}

	/**
	 * ユーザー情報 新規登録
	 * 
	 * @param user ユーザー情報
	 */
	public void create(UserRequest userRequest) {
		LoginUser user = new LoginUser();
		user.setUserName(userRequest.getName());
		user.setPassword(userRequest.getPassword());
		userRepository.save(user);
	}

	/**
	 * ユーザー情報 主キー検索
	 * 
	 * @return 検索結果
	 */
	public LoginUser findById(Long id) {
		return userRepository.findById(id).get();
	}

	/**
	 * ユーザー情報 更新
	 * 
	 * @param user ユーザー情報
	 */
	public void update(UserUpdateRequest userUpdateRequest) {
		LoginUser user = findById(userUpdateRequest.getId());
		user.setUserName(userUpdateRequest.getName());
		user.setPassword(userUpdateRequest.getPassword());
		userRepository.save(user);
	}

	/**
	 * ユーザー情報 物理削除
	 * 
	 * @param id ユーザーID
	 */
	public void delete(Long id) {
		LoginUser user = findById(id);
		userRepository.delete(user);
	}
}