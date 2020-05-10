package com.elements.elementsapi.api.charactertemplate.service;

import com.elements.elementsapi.api.charactertemplate.repository.CharacterTemplateRepository;
import com.elements.elementsapi.api.charactertemplate.service.mapper.CharacterTemplateMapper;
import com.elements.elementsapi.api.charactertemplate.service.resource.CharacterTemplateDto;
import com.elements.elementsapi.api.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.shared.service.ImageEntityService;
import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.document.charactertemplate.CharacterTemplate;
import com.elements.elementsdomain.shared.image.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class CharacterTemplateService extends ImageEntityService<CharacterTemplateDto, CharacterTemplate> {

    private final CharacterTemplateRepository repository;
    private final CharacterTemplateMapper mapper;

    public CharacterTemplateService(
            FileStorageService fileStorageService,
            CharacterTemplateRepository repository,
            CharacterTemplateMapper characterTemplateMapper
    ) {
        super(fileStorageService);
        this.repository = repository;
        this.mapper = characterTemplateMapper;
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
    protected void addImageToEntity(CharacterTemplate entity, String imageKey, Image image) {
        if (entity.getImages() == null) {
            entity.setImages(new HashMap<>());
        }
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

    public List<CharacterTemplate> findTemplates() {
        return repository.findAll();
    }
}
