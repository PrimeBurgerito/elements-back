package com.elements.elementsapi.config;

import com.arangodb.springframework.annotation.EnableArangoRepositories;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
@EnableArangoRepositories(basePackages = {"com.elements.elementsapi"})
public class ResourceServerConfig {
}
