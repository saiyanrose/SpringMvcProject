package com.mvc.security;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication()
			.withUser("admin@gmail.com")
			.password("admin123")
			.authorities("ROLE_ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		http.csrf().disable()			
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated()			
			.and()
				.formLogin().loginPage("/login")
				.defaultSuccessUrl("/dashboard")
				.failureUrl("/login?error")
				.usernameParameter("email").passwordParameter("password")				
			.and()
				.logout().logoutSuccessUrl("/login?logout"); 		
	}
}
