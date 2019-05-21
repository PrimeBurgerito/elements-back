package com.elements.elementsapi.api.charactertemplate.service;

import com.elements.elementsapi.api.charactertemplate.repository.CharacterTemplateRepository;
import com.elements.elementsapi.api.charactertemplate.service.mapper.CharacterTemplateMapper;
import com.elements.elementsapi.api.charactertemplate.service.resource.CharacterTemplateDto;
import com.elements.elementsapi.api.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.shared.service.ImageEntityService;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.character.CharacterTemplate;
import com.elements.elementsdomain.image.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CharacterTemplateService extends ImageEntityService<CharacterTemplateDto, CharacterTemplate> {

    private final CharacterTemplateRepository repository;
    private final CharacterTemplateMapper mapper;

    public CharacterTemplateService(
            FileStorageService fileStorageService,
            CharacterTemplateRepository repository,
            CharacterTemplateMapper mapper
    ) {
        super(fileStorageService);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MongoRepository<CharacterTemplate, String> getRepository() {
        return this.repository;
    }

    @Override
    protected BaseMapper<CharacterTemplateDto, CharacterTemplate> getMapper() {
        return this.mapper;
    }

    @Override
    public CharacterTemplateDto create(CharacterTemplateDto characterTemplateDto) {
        CharacterTemplate characterTemplate = mapper.map(characterTemplateDto);
        return mapper.map(repository.save(characterTemplate));
    }

    @Override
    public CharacterTemplateDto update(String characterTemplateId, CharacterTemplateDto characterTemplateDto) {
        CharacterTemplate characterTemplate = repository.findById(characterTemplateId)
                .orElseThrow(() -> new RuntimeException("Character template not found"));
        characterTemplate.setAttributes(characterTemplateDto.getAttributes());
        characterTemplate.setProperties(characterTemplateDto.getProperties());
        return mapper.map(repository.save(characterTemplate));
    }

    @Override
    protected void addImageToEntity(CharacterTemplate entity, String imageKey, Image image) {
        entity.getImages().put(imageKey, image);
    }

    @Override
    protected boolean removeImageFromEntity(CharacterTemplate entity, String imageKey) {
        if (entity.getImages().containsKey(imageKey)) {
            entity.getImages().remove(imageKey);
            return true;
        }
        return false;
    }
}
