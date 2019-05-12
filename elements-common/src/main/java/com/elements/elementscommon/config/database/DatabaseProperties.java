package com.elements.elementscommon.config.database;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@ConfigurationProperties(prefix = "spring.data.mongodb")
class DatabaseProperties {
    private String host;
    private int port;
    private String username;
    private String password;
    private String database;
    private String authenticationDatabase;
}
