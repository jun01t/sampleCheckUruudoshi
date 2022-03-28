package com.example.demo.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginUser;

@Repository
public class LoginUserDao {

	@Autowired
	EntityManager em;

	public LoginUser findUser(String userName) {
		String query = "";
		query += "SELECT * ";
		query += "FROM user ";
		query += "WHERE username = :userName ";

		return (LoginUser) em.createNativeQuery(query, LoginUser.class).setParameter("userName", userName)
				.getSingleResult();
	}
}
