package com.elements.elementsapi.api.npctemplate.service;

import com.elements.elementsapi.api.fileupload.service.FileStorageService;
import com.elements.elementsapi.api.npctemplate.repository.NpcTemplateRepository;
import com.elements.elementsapi.api.npctemplate.service.mapper.NpcTemplateMapper;
import com.elements.elementsapi.api.npctemplate.service.resource.NpcTemplateDto;
import com.elements.elementsapi.api.shared.service.ConditionalImageEntityService;
import com.elements.elementsdomain.aggregate.npc.NpcTemplate;
import com.elements.elementsdomain.composite.image.ConditionalImage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@Transactional
public class NpcTemplateService extends ConditionalImageEntityService<NpcTemplateDto, NpcTemplate> {

    private final NpcTemplateRepository repository;
    private final NpcTemplateMapper mapper;

    public NpcTemplateService(
            FileStorageService fileStorageService,
            NpcTemplateRepository repository,
            NpcTemplateMapper mapper
    ) {
        super(fileStorageService);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public NpcTemplateRepository getRepository() {
        return repository;
    }

    @Override
    protected NpcTemplateMapper getMapper() {
        return mapper;
    }

    @Override
    protected void addImageToEntity(NpcTemplate entity, ConditionalImage conditionalImage) {
        if (entity.getImages() == null) {
            entity.setImages(new HashSet<>());
        }
        entity.getImages().stream()
                .filter((ConditionalImage img) -> img.getImage().getKey().equals(conditionalImage.getImage().getKey()))
                .findFirst()
                .ifPresentOrElse(
                        (ConditionalImage img) -> img = conditionalImage,
                        () -> entity.getImages().add(conditionalImage)
                );
    }

    @Override
    protected boolean removeImageFromEntity(NpcTemplate entity, String imageKey) {
        return entity.getImages().removeIf(image -> imageKey.equals(image.getImage().getKey()));
    }
}
