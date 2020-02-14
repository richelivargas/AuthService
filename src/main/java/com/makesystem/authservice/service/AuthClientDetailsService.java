package com.makesystem.authservice.service;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import com.makesystem.authservice.repository.AuthClientRepository;

/**
 * Provide the details about an OAuth2 client.
 * 
 * @author Richeli Vargas
 * @since 0.0.1
 */
@Service
public class AuthClientDetailsService implements ClientDetailsService {
    private final AuthClientRepository authClientRepository;

    public AuthClientDetailsService(final AuthClientRepository authClientRepository) {
        this.authClientRepository = authClientRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(final String clientId) {
        return authClientRepository.findByClientId(clientId).orElseThrow(IllegalArgumentException::new);
    }
}
