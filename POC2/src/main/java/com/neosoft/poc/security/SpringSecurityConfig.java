//package com.neosoft.poc.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//@Configuration
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	//with database level
//	@Autowired
//	MyUserDetailsService userDetailsService;
//	
//	//create 2 users for demo
//	//(Authentication)
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 //with hard coded values
//		
//		//{noop} to your password in order for the DelegatingPassswordEncoder
//	/*	auth.inMemoryAuthentication().withUser("user").password("{noop}user123").roles("USER")
//		.and().withUser("admin").password("{noop}admin123").roles("USER","ADMIN"); */
//		
//		
//		//with database level
//		auth.userDetailsService(userDetailsService)
//		.passwordEncoder(NoOpPasswordEncoder.getInstance());
//		
//	}
//	
//	//Authorization
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	   
//		http.httpBasic()
//		.and()
//		.authorizeRequests()
//		.antMatchers(HttpMethod.GET,"/students").hasAnyRole("ADMIN","USER")
//		.antMatchers(HttpMethod.POST,"/projects/**").hasAnyRole("ADMIN")  //antMatchers(HttpMethod.POST,"/**").hasAnyRole("ADMIN") //for all end with post for admin
//		.antMatchers(HttpMethod.PUT,"/posts/**").hasAnyRole("ADMIN")
//		.antMatchers(HttpMethod.DELETE,"/posts/**").hasAnyRole("ADMIN")
//		.and()
//		.csrf().disable();
//	}
//
//}
//
//
