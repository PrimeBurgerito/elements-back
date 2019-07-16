package com.elements.gamesession.session.event.service;

import com.elements.elementsdomain.event.Event;
import com.elements.gamesession.session.event.domain.SessionEventValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SessionEventValidationService {

    SessionEventValidation validate(Event event) {
        SessionEventValidation validation = new SessionEventValidation();
        if (event == null) {
            validation.unAccept("event", "Can't be null");
        } else if (event.getScenes() == null) {
            validation.unAccept("scenes", "Can't be null");
        } else if (event.getScenes().isEmpty()) {
            validation.unAccept("scenes", "Can't be empty");
        }

        if (!validation.isCorrect()) {
            log.error("SessionEvent validation failed - Field: {}, Reason: {}", validation.getField(), validation.getReason());
        }
        return validation;
    }
}
