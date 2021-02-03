package com.elements.elementsapi.config.security;

import com.elements.elementscommon.config.security.JwtAuthenticationConverter;
import com.elements.elementscommon.config.security.JwtTokenDecoder;
import com.elements.elementscommon.config.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import static org.springframework.web.cors.CorsConfiguration.ALL;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final String[] ALLOWED_PATTERNS = new String[]{
            "/authentication/**",
            "/user/create",
            "/auth/test/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    };

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false);
        config.addAllowedOrigin(ALL);
        config.addAllowedHeader(ALL);
        config.addAllowedMethod(ALL);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling(configurer -> configurer.authenticationEntryPoint(new UnauthorizedEntryPoint()))
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(STATELESS))
                .authorizeRequests(registry -> {
                    registry.antMatchers(OPTIONS, "/**").permitAll();
                    registry.antMatchers(ALLOWED_PATTERNS).permitAll();
                    registry.anyRequest().authenticated();
                })
                .oauth2ResourceServer()
                .jwt(configuration -> {
                    configuration.decoder(new JwtTokenDecoder(jwtUtils));
                    configuration.jwtAuthenticationConverter(new JwtAuthenticationConverter(userDetailsService));
                });
    }
}
