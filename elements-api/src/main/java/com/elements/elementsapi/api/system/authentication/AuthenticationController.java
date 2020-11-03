package com.elements.elementsapi.api.system.authentication;

import com.elements.elementscommon.domain.authentication.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/authentication")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping
    public ResponseEntity<JwtResponse> authenticate(@Valid @RequestBody AuthenticationDto authentication) {
        return ResponseEntity.ok(service.authenticate(authentication.getUsername(), authentication.getPassword()));
    }
}
