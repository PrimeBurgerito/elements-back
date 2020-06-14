package com.elements.elementscommon.config.database;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static java.util.List.of;

@Slf4j
@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"com.elements"})
@RequiredArgsConstructor
@ComponentScan(basePackageClasses = {DatabaseProperties.class})
public class DatabaseConfiguration extends AbstractMongoClientConfiguration {

    private final DatabaseProperties db;
    private final Environment env;

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
    public boolean autoIndexCreation() {
        return true;
    }

    @Override
    public @NotNull MongoClient mongoClient() {
        ServerAddress address = new ServerAddress(db.getHost(), db.getPort());
        if (env.acceptsProfiles(Profiles.of("aws"))) {
            String mongoAddress = "mongodb://" + address.toString();
            log.debug("Connecting to MongoDb with 'aws' profile: " + mongoAddress);
            return MongoClients.create(mongoAddress);
        }

        var settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder.hosts(of(address)))
                .build();

        log.debug("Connecting to MongoDb with 'aws' profile: " + address.toString());
        return MongoClients.create(settings);
    }

    @Override
    protected @NotNull String getDatabaseName() {
        return db.getDatabase();
    }
}
