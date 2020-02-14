package com.makesystem.authservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserRegistrationDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5063910253259651874L;

	@NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
