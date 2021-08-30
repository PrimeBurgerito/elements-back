package com.elements.elementsapi.api.game.charactertemplate.service;

import com.elements.elementsapi.api.game.charactertemplate.service.resource.CharacterTemplateDto;
import com.elements.elementsapi.api.realm.service.RealmDocumentImageService;
import com.elements.elementsdomain.document.charactertemplate.CharacterTemplate;
import com.elements.elementsdomain.shared.image.Image;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class CharacterTemplateService extends RealmDocumentImageService<CharacterTemplateDto, CharacterTemplate> {

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

    public List<CharacterTemplate> findTemplates(String realmId) {
        return realmId != null ? repository.findAllByRealmId(realmId) : repository.findAll();
    }
}
