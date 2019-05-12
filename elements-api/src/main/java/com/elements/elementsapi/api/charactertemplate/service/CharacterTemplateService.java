package com.elements.elementsapi.api.charactertemplate.service;

import com.elements.elementsapi.api.charactertemplate.repository.CharacterTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterTemplateService {

    private final CharacterTemplateRepository characterTemplateRepository;
    
}
