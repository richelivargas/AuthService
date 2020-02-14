package com.makesystem.authservice.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1382537889288813614L;

	private String id;

    private String username;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}
