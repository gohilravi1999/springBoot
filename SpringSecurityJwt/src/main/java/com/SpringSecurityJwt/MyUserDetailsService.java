package com.SpringSecurityJwt;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService
{

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException 
	{
		return new User("Ravi","Ravi", new ArrayList<>());
	}

}
