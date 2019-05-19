package com.elements.elementsapi.config;

import com.elements.elementsapi.config.properties.TokenProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfig {

    private final TokenProperties tokenProps;

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.elements.elementsapi.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(singletonList(oauth()))
                .securityContexts(singletonList(securityContext()));
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(List.of(new SecurityReference("OAuth2", createScopes())))
                .build();
    }

    private SecurityScheme oauth() {
        return new OAuthBuilder()
                .name("Oauth2")
                .scopes(asList(createScopes()))
                .grantTypes(singletonList(createGrant()))
                .build();
    }

    private AuthorizationScope[] createScopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope("read", "Grants read access"),
                new AuthorizationScope("write", "Grants write access"),
                new AuthorizationScope("trust", "Grants read write and delete access")
        };
    }

    private GrantType createGrant() {
        TokenRequestEndpoint tokenRequestEndpoint = new TokenRequestEndpointBuilder()
                .url(tokenProps.getServerUri() + "/authorize")
                .clientIdName(tokenProps.getClientIdSwagger())
                .clientSecretName(tokenProps.getClientSecretSwagger())
                .build();

        return new AuthorizationCodeGrantBuilder()
                .tokenEndpoint(new TokenEndpoint(tokenProps.getServerUri() + "/token", "oauthtoken"))
                .tokenRequestEndpoint(tokenRequestEndpoint)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API for Game",
                "All of the API endpoints for Game are here",
                "0.0.1",
                "Terms of service",
                new Contact("John Doe", "www.example.com", "burgerito@protonmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
