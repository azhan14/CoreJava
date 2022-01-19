package com.neosoft.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	// for DB
	@Autowired
	MyUserDetailService userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService)
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/student").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/project").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/project").hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.GET,"/student/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/project/**/student").hasAnyRole("ADMIN","USER")
		.and()
		.csrf().disable();
	}
}
