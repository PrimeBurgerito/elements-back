package com.elements.elementsapi.api.game.npctemplate.service;

import com.elements.elementsapi.api.game.npctemplate.service.resource.NpcTemplateDto;
import com.elements.elementsapi.api.realm.service.RealmDocumentConditionalImageService;
import com.elements.elementsdomain.document.npc.NpcTemplate;
import com.elements.elementsdomain.shared.image.ConditionalImage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@Transactional
public class NpcTemplateService extends RealmDocumentConditionalImageService<NpcTemplateDto, NpcTemplate> {

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
