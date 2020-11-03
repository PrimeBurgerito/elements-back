package com.elements.elementsapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.Collections.singletonList;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfiguration {
    private static final String SECURITY_SCHEMA = "bearer-key";
    private static final String BEARER = "bearer";
    private static final String JWT = "JWT";

    @Bean
    public OpenAPI customOpenAPI() {
        Components components = new Components().addSecuritySchemes(SECURITY_SCHEMA, jwtSchema());
        SecurityRequirement security = new SecurityRequirement().addList(SECURITY_SCHEMA);

        return new OpenAPI()
                .components(components)
                .security(singletonList(security));
    }

    private SecurityScheme jwtSchema() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme(BEARER)
                .bearerFormat(JWT);
    }
}
