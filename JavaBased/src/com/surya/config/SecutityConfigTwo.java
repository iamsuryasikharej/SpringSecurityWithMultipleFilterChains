package com.surya.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@Order(1)
public class SecutityConfigTwo extends WebSecurityConfigurerAdapter{
@Autowired
PasswordEncoder p;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		http.authorizeRequests()
//	   
//	    .antMatchers("/test1/hi").authenticated()
//	    .and().formLogin();
		http.antMatcher("/test1/hi").httpBasic().and().authorizeRequests().antMatchers("/test1/hi").authenticated();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		     .withUser("admin")
		     .password(p.encode("admin"))
		     .roles("ADMIN");
	}


}
