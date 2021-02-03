package com.elements.gamesession.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.security.config.http.SessionCreationPolicy.IF_REQUIRED;


@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SessionWebSecurity extends WebSecurityConfigurerAdapter {
    private final String[] ALLOWED_PATTERNS = new String[]{
            "/csrf",
            "/start-session"
    };

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().anyRequest();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling(configurer -> configurer.accessDeniedHandler((request, response, authException) -> {
                    log.error("Unauthorized error: {}", authException.getMessage());
                    response.sendError(SC_UNAUTHORIZED, "Error: Unauthorized");
                }))
                .sessionManagement(configurer -> {
                    configurer.sessionCreationPolicy(IF_REQUIRED);
                    configurer.maximumSessions(1);
                })
                .authorizeRequests(registry -> {
                    registry.antMatchers(OPTIONS, "/**").permitAll();
                    registry.antMatchers(ALLOWED_PATTERNS).permitAll();
                    registry.anyRequest().authenticated();
                });
    }
}
