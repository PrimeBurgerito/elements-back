package com.elements.elementsapi.api.charactertemplate.service.mapper;

import com.elements.elementsapi.api.charactertemplate.service.resource.CharacterTemplateDto;
import com.elements.elementsapi.api.property.repository.NumericPropertyRepository;
import com.elements.elementsapi.api.property.repository.StringPropertyRepository;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.document.charactertemplate.CharacterTemplate;
import com.elements.elementsdomain.document.propertytemplate.NumericPropertyTemplate;
import com.elements.elementsdomain.document.propertytemplate.StringPropertyTemplate;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.elementsdomain.shared.property.NumericProperty;
import com.elements.elementsdomain.shared.property.StringProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CharacterTemplateMapper implements BaseMapper<CharacterTemplateDto, CharacterTemplate> {

    private final StringPropertyRepository stringPropertyService;
    private final NumericPropertyRepository numericPropertyRepository;

    @Override
    public CharacterTemplateDto map(CharacterTemplate template) {
        return CharacterTemplateDto.builder()
                .numericProperties(template.getProperties().getNumericPropertyKeyToValue())
                .stringProperties(template.getProperties().getStringPropertyKeyToValue())
                .build();
    }

    @Override
    public List<CharacterTemplateDto> map(Collection<CharacterTemplate> locations) {
        return locations.stream().map(this::map).collect(toList());
    }

    @Override
    public CharacterTemplate map(CharacterTemplateDto templateDto) {
        List<NumericPropertyTemplate> numericPropertyTemplates = numericPropertyRepository.findAll();
        List<StringPropertyTemplate> stringPropertyTemplates = stringPropertyService.findAll();

        List<NumericProperty> numericProperties = numericPropertyTemplates.stream().map(template -> {
            Float value = templateDto.getNumericProperties().get(template.getKey());
            return template.toProperty(value);
        }).collect(toList());

        List<StringProperty> stringProperties = stringPropertyTemplates.stream().map(template -> {
            List<String> value = templateDto.getStringProperties().get(template.getKey());
            return template.toProperty(value);
        }).collect(toList());

        CharacterProperties properties = CharacterProperties.builder()
                .numericProperties(numericProperties)
                .stringProperties(stringProperties)
                .build();

        return CharacterTemplate.builder().properties(properties).build();
    }

    @Override
    public void update(CharacterTemplateDto dto, CharacterTemplate document) {
        dto.getNumericProperties().forEach((key, value) -> document
                .getProperties()
                .getKeyToNumericProperty()
                .get(key)
                .setValue(value)
        );
        dto.getStringProperties().forEach((key, value) -> document
                .getProperties()
                .getKeyToStringProperty()
                .get(key)
                .setValue(value)
        );
    }
}
