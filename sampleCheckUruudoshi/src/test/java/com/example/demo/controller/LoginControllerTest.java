package com.example.demo.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.entity.LoginUser;
import com.example.demo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginControllerTest {

	private MockMvc mockMvc;

	@Autowired
	MainController target;

	@MockBean
	private UserService userService;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(target).build();
	}

	@Test
	public void formLoginWithUserAndPassword_1() throws Exception {
		// 正常系
		String user = "user";
		String password = "password";
		Long id = 6L;
		LoginUser userModel = new LoginUser();
		userModel.setUserName(user);
		userModel.setPassword(password);
		doReturn(userModel).when(userService).findById(id);

		mockMvc.perform(formLogin("/login").user(user).password("password")).andExpect(status().isOk());
	}
}
