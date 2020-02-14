package com.makesystem.authservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.makesystem.authservice.domain.AuthClientDetails;

/**
 * 
 * @author Richeli Vargas
 * @since 0.0.1
 */
@Repository
public interface AuthClientRepository extends MongoRepository<AuthClientDetails, String> {
    Optional<AuthClientDetails> findByClientId(final String clientId);
}
