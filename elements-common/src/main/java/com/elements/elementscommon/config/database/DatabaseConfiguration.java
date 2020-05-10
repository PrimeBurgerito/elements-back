package com.elements.elementscommon.config.database;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"com.elements"})
@RequiredArgsConstructor
@ComponentScan(basePackageClasses = {DatabaseProperties.class})
public class DatabaseConfiguration extends AbstractMongoClientConfiguration {

    private final DatabaseProperties db;

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorProvider();
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    private MongoCredential getMongoCredentials() {
        String authDb = db.getAuthenticationDatabase();
        char[] password = db.getPassword().toCharArray();
        return MongoCredential.createScramSha1Credential(db.getUsername(), authDb, password);
    }

    @Override
    public MongoClient mongoClient() {
//        ServerAddress address = new ServerAddress(db.getHost(), db.getPort());
        //MongoClientOptions options = MongoClientOptions.builder().build();
        var addresses = List.of(new ServerAddress(db.getHost(), db.getPort()));
        var settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder.hosts(addresses))
                .build();

        return MongoClients.create(settings);
    }

    @Override
    protected String getDatabaseName() {
        return db.getDatabase();
    }
}
