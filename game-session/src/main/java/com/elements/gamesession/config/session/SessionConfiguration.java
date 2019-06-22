package com.elements.gamesession.config.session;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapAttributeConfig;
import com.hazelcast.config.MapIndexConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.hazelcast.PrincipalNameExtractor;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import static org.springframework.session.hazelcast.HazelcastSessionRepository.DEFAULT_SESSION_MAP_NAME;
import static org.springframework.session.hazelcast.HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE;

@Configuration
@EnableHazelcastHttpSession
public class SessionConfiguration {

    @Bean
    public HazelcastInstance hazelcastInstance() {
        MapAttributeConfig attributeConfig = new MapAttributeConfig()
                .setName(PRINCIPAL_NAME_ATTRIBUTE)
                .setExtractor(PrincipalNameExtractor.class.getName());

        Config config = new Config();
        config.getMapConfig(DEFAULT_SESSION_MAP_NAME)
                .addMapAttributeConfig(attributeConfig)
                .addMapIndexConfig(new MapIndexConfig(PRINCIPAL_NAME_ATTRIBUTE, false));

        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}
