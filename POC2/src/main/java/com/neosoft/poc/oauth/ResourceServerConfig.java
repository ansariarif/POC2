package com.neosoft.poc.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
/*		authorizeRequests()
        .antMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN")
        .antMatchers(HttpMethod.POST,"/insert/student").hasAnyRole("ADMIN","USER")// (3)
        .anyRequest().authenticated();*/
		
		authorizeRequests()
		.antMatchers(HttpMethod.POST,"/insert/student").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.GET,"/**")
//		.antMatchers(HttpMethod.POST,"/insert/student")
		.authenticated();
//		.and()
//		.csrf().disable();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
        .withUser("arif")
        .password(passwordEncoder().encode("arif123"))
        .roles("USER");
		
	}

	
	


}
