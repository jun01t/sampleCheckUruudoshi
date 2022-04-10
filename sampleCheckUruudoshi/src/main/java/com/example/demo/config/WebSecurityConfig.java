package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.UserDetailsServiceImpl;

/**
 * SpringSecurityを利用するための設定クラス ログイン処理でのパラメータ、画面遷移や認証処理でのデータアクセス先を設定する
 * 
 * @author aoi
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	// フォームの値と比較するDBから取得したパスワードは暗号化されているのでフォームの値も暗号化するために利用
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	/**
	 * 認可設定を無視するリクエストを設定 静的リソース(image,javascript,css)を認可処理の対象から除外する
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/css/**", "/javascript/**", "/assets/**");
	}

	/**
	 * 認証・認可の情報を設定する 画面遷移のURL・パラメータを取得するname属性の値を設定
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// 「login.html」はログイン不要でアクセス可能に設定
				.antMatchers("/login", "/user/**", "/loginError").permitAll()
				// 上記以外は直リンク禁止
				.anyRequest().authenticated().and().formLogin()
				// ログイン処理のパス
				.loginProcessingUrl("/sign_in")
				// ログインページ
				.loginPage("/login")
				// ログインエラー時の遷移先 ※パラメーターに「error」を付与
				.failureUrl("/loginError")
				// ログイン成功時の遷移先
				.defaultSuccessUrl("/home", true)
				// ログイン時のキー：名前
				.usernameParameter("username")
				// ログイン時のパスワード
				.passwordParameter("password").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutUrl("/logout") // ログアウトのURL
				.invalidateHttpSession(true)
				// ログアウト時の遷移先 POSTでアクセス
				.logoutSuccessUrl("/afterLogout");

	}

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}