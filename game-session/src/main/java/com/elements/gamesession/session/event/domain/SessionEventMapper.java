package com.elements.gamesession.session.event.domain;

import com.elements.elementsdomain.character.CharacterStatistics;
import com.elements.elementsdomain.event.scene.Scene;
import com.elements.elementsdomain.event.scene.SceneImage;
import com.elements.elementsdomain.event.scene.option.Option;
import com.elements.elementsdomain.event.scene.option.SceneOption;
import com.elements.gamesession.engine.requirement.RequirementTester;
import com.elements.gamesession.engine.requirement.RequirementTesterUserInfo;

import java.util.List;

import static java.util.stream.Collectors.toList;

class SessionEventMapper {

    private SessionEventMapper() {
    }

    static SessionEvent map(Scene scene) {
        if (scene == null) {
            return null;
        }
        return getNewSessionEvent(scene);
    }

    static SessionEvent map(SceneOption scene, CharacterStatistics statistics) {
        if (scene == null) {
            return null;
        }
        SessionEvent sessionEvent = getNewSessionEvent(scene);
        RequirementTester tester = getOptionRequirementTester(statistics);
        sessionEvent.setOptions(mapSceneOptions(scene, tester));
        return sessionEvent;
    }

    private static SessionEvent getNewSessionEvent(SceneImage scene) {
        return SessionEvent.builder()
                .text(scene.getText())
                .image(scene.getImage())
                .type(scene.getType())
                .build();
    }

    private static RequirementTester getOptionRequirementTester(CharacterStatistics statistics) {
        RequirementTester tester = new RequirementTester();
        RequirementTesterUserInfo userInfo = RequirementTesterUserInfo.builder()
                .attributes(statistics.getAttributes())
                .properties(statistics.getProperties())
                .objectives(statistics.getObjectives())
                .build();
        tester.setUserInfo(userInfo);
        return tester;
    }

    private static List<SessionOption> mapSceneOptions(SceneOption scene, RequirementTester tester) {
        return scene.getOptions().stream().map(o -> map(o, tester)).collect(toList());
    }

    private static SessionOption map(Option option, RequirementTester tester) {
        tester.setRequirement(option.getRequirement());
        return SessionOption.builder()
                .text(option.getText())
                .disabled(!tester.isSatisfied())
                .build();
    }
}
