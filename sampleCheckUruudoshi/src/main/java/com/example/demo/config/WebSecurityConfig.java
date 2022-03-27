package com.example.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 認可設定を無視するリクエストを設定 静的リソース(image,javascript,css)を認可処理の対象から除外する
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**").antMatchers("/images/**").antMatchers("/css/**")
				.antMatchers("/javascript/**").antMatchers("/js/**").antMatchers("/images/**", "/css/**");
	}

	/**
	 * 認証・認可の情報を設定する
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().mvcMatchers("/login").permitAll().anyRequest().authenticated();

		http.logout().logoutSuccessUrl("/login").permitAll();

		http.formLogin().defaultSuccessUrl("/");
	}

}
