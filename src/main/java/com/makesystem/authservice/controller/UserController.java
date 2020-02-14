package com.makesystem.authservice.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makesystem.authservice.domain.User;
import com.makesystem.authservice.dto.UserDto;
import com.makesystem.authservice.dto.UserRegistrationDto;
import com.makesystem.authservice.service.UserService;

/**
 * 
 * @author Richeli Vargas
 * @since 0.0.1
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }
	
    @GetMapping("/current")
    public Principal getUser(final Principal principal) {
        return principal;
    }

    @PostMapping
    @PreAuthorize("#oauth2.hasScope('server')")
    public UserDto createUser(@Valid @RequestBody final UserRegistrationDto userRegistration) {
        final User savedUser = userService.create(toUser(userRegistration));
        return toDto(savedUser);
    }

    private UserDto toDto(final User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    private User toUser(final UserRegistrationDto userRegistration) {
        final User user = new User();
        user.setUsername(userRegistration.getUsername());
        user.setPassword(userRegistration.getPassword());
        return user;
    }

}
