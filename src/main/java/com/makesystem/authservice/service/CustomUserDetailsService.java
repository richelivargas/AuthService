package com.makesystem.authservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.makesystem.authservice.repository.UserRepository;

/**
 * It is a core interface which loads user-specific data. It is used throughout
 * the spring framework as a user DAO and is the strategy used by the
 * DaoAuthenticationProvider.
 * 
 * @author Richeli Vargas
 * @since 0.0.1
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final static String USERNAME_NOT_FOUND = "Username %s not found";

	private final UserRepository userRepository;

	public CustomUserDetailsService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(USERNAME_NOT_FOUND, username)));
	}

}
