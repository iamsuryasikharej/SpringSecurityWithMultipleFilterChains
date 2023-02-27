package com.surya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		     .withUser("admin")
		     .password(getPEncoder().encode("admin"))
		     .roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.antMatcher("/test1/hello").httpBasic().and().authorizeRequests().antMatchers("/test1/hello").authenticated();
//		http
//        .formLogin()
//        .and()
//        .authorizeRequests().antMatchers("/test1/hello").authenticated();
		
//		http.antMatcher("/test1/hi").httpBasic().and().authorizeRequests().antMatchers("/test1/hi").authenticated();
		
	}
	@Bean
	public PasswordEncoder getPEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
