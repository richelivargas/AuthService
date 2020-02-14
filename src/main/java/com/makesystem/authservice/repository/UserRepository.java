package com.makesystem.authservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.makesystem.authservice.domain.User;

/**
 * 
 * @author Richeli Vargas
 * @since 0.0.1
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByUsername(final String username);

}
