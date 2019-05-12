package com.elements.elementscommon.config.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"com.elements"})
@RequiredArgsConstructor
@ComponentScan(basePackageClasses = {DatabaseProperties.class})
public class DatabaseConfiguration extends AbstractMongoConfiguration {

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
        ServerAddress address = new ServerAddress(db.getHost(), db.getPort());
        //MongoClientOptions options = MongoClientOptions.builder().build();
        return new MongoClient(address);
    }

    @Override
    protected String getDatabaseName() {
        return db.getDatabase();
    }
}
