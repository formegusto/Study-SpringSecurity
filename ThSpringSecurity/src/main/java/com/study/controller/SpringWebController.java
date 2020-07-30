package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SpringWebController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signupForm() {
		return "signup";
	}
	@GetMapping("/loginResult")
	public String loginSuccess() {
		return "/loginResult";
	}
	
	@GetMapping("/loginFail")
	public String loginFail() {
		return "/loginFail";
	}
	
	@GetMapping("/myinfo")
	public String myinfo() {
		return "/member/myInfo";
	}
	
	@GetMapping("/admin")
	public String adminMain() {
		return "/admin/index";
	}
	
	@GetMapping("/denied")
	public String denied() {
		return "/denied";
	}
}
