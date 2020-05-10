package com.elements.gamesession.session.crud.event.service;

import com.elements.elementsdomain.document.event.Event;
import com.elements.gamesession.session.crud.event.domain.SessionEventValidation;
import com.elements.gamesession.session.crud.event.domain.SceneStateOption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SessionEventValidationService {

    SessionEventValidation validate(Event event) {
        SessionEventValidation validation = new SessionEventValidation();
        if (event == null) {
            validation.unAccept("event", "Value is null");
        } else if (event.getScenes() == null) {
            validation.unAccept("scenes", "Can't be null");
        } else if (event.getScenes().isEmpty()) {
            validation.unAccept("scenes", "Can't be empty");
        }

        if (!validation.isCorrect()) {
            log.error("SessionEvent validation failed - Field: {}, Reason: {}",
                    validation.getField(), validation.getReason());
        }
        return validation;
    }

    SessionEventValidation validate(List<SceneStateOption> options, Integer option) {
        SessionEventValidation validation = new SessionEventValidation();
        if (option == null) {
            validation.unAccept("option", "Value is null");
        } else if (option >= options.size()) {
            validation.unAccept("option", "Index is out of bounds");
        } else if (options.get(option).isDisabled()) {
            validation.unAccept("disabled", "Selected option is disabled");
        }

        if (!validation.isCorrect()) {
            log.error("SessionOption validation failed - Field: {}, Reason: {}",
                    validation.getField(), validation.getReason());
        }
        return validation;
    }
}
