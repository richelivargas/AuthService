package com.makesystem.authservice.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * This enum is responsible to define the authorities of our auth service and it
 * implements the GrantedAuthority interface which represents an authority
 * granted to an Authentication object.
 * 
 * @author Richeli Vargas
 * @since 0.0.1
 */
public enum Authorities implements GrantedAuthority {
	ROLE_USER;

	@Override
	public String getAuthority() {
		return name();
	}
}