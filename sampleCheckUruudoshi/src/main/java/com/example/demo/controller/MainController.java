package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.Form1;
import com.example.demo.service.UruudoshiService;
import com.example.demo.service.checkInputYearUruudoshi;
import com.example.demo.service.checkNowYearUruudoshi;

@Controller
public class MainController {

	@RequestMapping(value = "/home")
	private String now(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// Principalからログインユーザの情報を取得
		String userName = auth.getName();
		model.addAttribute("userName", userName);
		checkNowYearUruudoshi target = new checkNowYearUruudoshi();
		model.addAttribute("list", target.getNowYearUruudoshi());
		return "now";
	}

	// ログイン成功時のメニュー画面への遷移
	@PostMapping
	String postLogin() {
		return "redirect:/home";
	}

	@RequestMapping(value = "/list")
	private String list(Model model) {
		UruudoshiService target = new UruudoshiService();
		model.addAttribute("list", target.getUruudhosiList());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// Principalからログインユーザの情報を取得
		String userName = auth.getName();
		model.addAttribute("userName", userName);
		return "list";
	}

	@RequestMapping("/check")
	public String check(Model model) {
		if (!model.containsAttribute("test1Form")) {
			model.addAttribute("test1Form", new Form1());
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// Principalからログインユーザの情報を取得
		String userName = auth.getName();
		model.addAttribute("userName", userName);
		return "check";
	}

	@PostMapping("/result")
	public String buyItem(@ModelAttribute("test1Form") @Validated Form1 test1Form, BindingResult br,
			RedirectAttributes redirectAttributes, Model model) {
		// メソッド内で行う処理
		if (br.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.test1Form", br);
			redirectAttributes.addFlashAttribute("test1Form", test1Form);
			return "redirect:check";
		}
		checkInputYearUruudoshi target = new checkInputYearUruudoshi();
		String s = target.checkInputYear(Integer.parseInt(test1Form.getYear()));
		model.addAttribute("list", s);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// Principalからログインユーザの情報を取得
		String userName = auth.getName();
		model.addAttribute("userName", userName);
		return "result";
	}

	@RequestMapping("/afterLogout")
	public String afterLogout() {
		return "afterLogout";
	}

	@RequestMapping("/loginError")
	public String loginError() {
		return "loginError";
	}
}