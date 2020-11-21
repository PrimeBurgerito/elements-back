package com.elements.elementscommon.config.database;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Slf4j
@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"com.elements"})
@RequiredArgsConstructor
public class DatabaseConfiguration {
/*
    private final Environment env;
    private final MongoProperties db;*/

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorProvider();
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory mongoDatabaseFactory) {
        return new MongoTransactionManager(mongoDatabaseFactory);
    }
/*
    @Override
    public boolean autoIndexCreation() {
        return db.isAutoIndexCreation();
    }

    @Override
    public @NotNull MongoClient mongoClient() {
        log.info("Connecting to mongo with active profiles '{}'", List.of(env.getActiveProfiles()));
        if (!MongoProperties.DEFAULT_URI.equals(db.getUri())) {
            log.info("Connecting to MongoDb on '{}'", db.getUri());
            return MongoClients.create(new ConnectionString(db.getUri()));
        }

        ServerAddress address = new ServerAddress(db.getHost(), db.getPort());
        if (env.acceptsProfiles(Profiles.of("aws", "heroku"))) {
            String mongoAddress = "mongodb://" + address.toString();
            log.debug("Connecting to MongoDb with 'aws' profile: {}", mongoAddress);
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
    }*/
}
