package com.study.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import com.study.service.security.CustomUserDetailService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
    }
 
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/css/**", "/script/**", "image/**", "/fonts/**", "lib/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
        // 페이지 권한 설정
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .antMatchers("/myinfo").hasRole("MEMBER")
                        .antMatchers("/**").permitAll()
                        .and() // 로그인 설정
                        .formLogin()
                        	.loginPage("/login")
                        	.loginProcessingUrl("/login")
                        	.defaultSuccessUrl("/login/result")
                        	.failureUrl("/loginFail")
                        	.permitAll()
                        .and()// 403 예외처리 핸들링
                        	.exceptionHandling().accessDeniedPage("/user/denied");
	}
}
