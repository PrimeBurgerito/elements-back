package com.elements.elementscommon.config.database;

import com.arangodb.ArangoDB;
import com.arangodb.entity.LoadBalancingStrategy;
import com.arangodb.springframework.annotation.EnableArangoAuditing;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import com.elements.elementscommon.config.properties.DatabaseProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
@ComponentScan(basePackageClasses = {DatabaseProperties.class})
@EnableArangoAuditing
@EnableArangoRepositories(basePackages = {"com.elements"})
public class DatabaseConfiguration implements ArangoConfiguration {

    private final DatabaseProperties db;

    public DatabaseConfiguration(DatabaseProperties databaseProperties) {
        this.db = databaseProperties;
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorProvider();
    }

    @Override
    public ArangoDB.Builder arango() {
        return new ArangoDB.Builder()
                .host(db.getHost(), db.getPort())
                .user(db.getUser())
                .password(db.getPassword())
                .loadBalancingStrategy(LoadBalancingStrategy.ROUND_ROBIN);
    }

    @Override
    public String database() {
        return db.getDatabase();
    }
}
