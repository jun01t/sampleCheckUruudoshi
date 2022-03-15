package com.example.demo.controller;

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

	@RequestMapping(value = "/")
	private String now(Model model) {
		checkNowYearUruudoshi target = new checkNowYearUruudoshi();
		model.addAttribute("list", target.getNowYearUruudoshi());
		return "now";
	}

	@RequestMapping(value = "/list")
	private String list(Model model) {
		UruudoshiService target = new UruudoshiService();
		model.addAttribute("list", target.getUruudhosiList());
		return "list";
	}

	@RequestMapping("/check")
	public String check(Model model) {
		if (!model.containsAttribute("test1Form")) {
			model.addAttribute("test1Form", new Form1());
		}
		return "check";
	}

	@PostMapping("/result")
	public String buyItem(@ModelAttribute("test1Form") @Validated Form1 test1Form,
			BindingResult br,
			RedirectAttributes redirectAttributes, Model model) {
		//メソッド内で行う処理
		if (br.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.test1Form", br);
			redirectAttributes.addFlashAttribute("test1Form", test1Form);
			return "redirect:check";
		}
		checkInputYearUruudoshi target = new checkInputYearUruudoshi();
		String s = target.checkInputYear(Integer.parseInt(test1Form.getYear()));
		model.addAttribute("list", s);

		return "result";
	}
}