package com.study.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.entity.Member;
import com.study.entity.MemberRole;
import com.study.repository.MemberRepository;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;
	
	@PostMapping("/signup")
	public String signup(Member vo) {
		MemberRole role = new MemberRole();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		vo.setUpw(passwordEncoder.encode(vo.getUpw()));
		role.setRoleName("MEMBER");
		vo.setRoles(Arrays.asList(role));
		memberRepository.save(vo);
		
		return "redirect:/";
	}
	
	@PostMapping("/signin")
	public String signin(Member vo) {
		System.out.println(vo);
		return "/login/result";
	}
}