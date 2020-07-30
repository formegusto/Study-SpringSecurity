package com.study.service.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.entity.Member;
import com.study.repository.MemberRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> userEntityWrapper = memberRepository.findByUemail(username);
		Member user = userEntityWrapper.get();
		System.out.println(user);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRoles().get(0).getRoleName()));
		
		return new User(user.getUemail(), user.getUpw(), authorities);
	}

	
}