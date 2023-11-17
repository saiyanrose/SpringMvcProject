package com.mvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mvc.models.User;
import com.mvc.service.UserService;

@Service
public class CustomeUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userService.getUserByEmail(username);
		if(user!=null) {
			return new CustomUserDetails(user);
		}else {
			throw new UsernameNotFoundException("User Not Found: " +username);
		}
	}

}
