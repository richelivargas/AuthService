package com.makesystem.authservice.config.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 
 * @author Richeli Vargas
 * @since 0.0.1
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.marcusdacoregio.authservice.repository")
public class MongoConfig {

}
