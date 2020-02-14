package com.makesystem.authservice.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.makesystem.authservice.domain.User;
import com.makesystem.authservice.enums.Authorities;
import com.makesystem.authservice.repository.UserRepository;

/**
 * 
 * @author Richeli Vargas
 * @since 0.0.1
 */
@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(final PasswordEncoder passwordEncoder, final UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public User create(final User user) {
        throwIfUsernameExists(user.getUsername());

        final String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setActivated(Boolean.TRUE); // TODO send sms or email with code for activation
        user.setAuthorities(new HashSet<>(Collections.singletonList(Authorities.ROLE_USER)));

        // TODO other routines on account creation

        return userRepository.save(user);
    }

    private void throwIfUsernameExists(final String username) {
        final Optional<User> existingUser = userRepository.findByUsername(username);
        existingUser.ifPresent((user) -> {
            throw new IllegalArgumentException("User not available");
        });
    }

}
