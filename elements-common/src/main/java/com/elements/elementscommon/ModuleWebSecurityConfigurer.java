package com.elements.elementscommon;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface ModuleWebSecurityConfigurer {
    void configure(HttpSecurity http) throws Exception;
}
