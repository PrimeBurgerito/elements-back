package com.elements.gamesession.session.event.domain;

import com.elements.elementsdomain.event.Event;
import com.elements.elementsdomain.event.scene.Scene;
import com.elements.elementsdomain.event.scene.SceneOption;
import com.elements.elementsdomain.event.scene.SceneType;
import com.elements.elementsdomain.gamestate.character.CharacterStatistics;
import com.elements.gamesession.requirementengine.RequirementTester;
import com.elements.gamesession.requirementengine.RequirementTesterUserInfo;

import static java.util.stream.Collectors.toSet;

public class SessionEventMapper {

    private SessionEventMapper() {
    }

    public static SessionEvent map(Event event, CharacterStatistics statistics, String key) {
        if (event == null) {
            return null;
        }
        Scene scene = getScene(event, key);
        SessionEvent sessionEvent = SessionEvent.builder()
                .text(scene.getText())
                .image(scene.getImage())
                .type(scene.getType())
                .build();

        if (scene.getType() == SceneType.OPTION) {
            RequirementTester tester = getOptionRequirementTester(statistics);
            sessionEvent.setOptions(scene.getOptions().stream().map(o -> map(o, tester)).collect(toSet()));
        } else if (scene.getType() == SceneType.DEFAULT) {
            sessionEvent.setNextKey(scene.getNextKey());
        }
        return sessionEvent;
    }

    private static Scene getScene(Event event, String key) {
        if (key == null) {
            return event.getScenes().get(0);
        }
        return event.getScenes().stream().filter(s -> s.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No scene with key: " + key));
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

    private static SessionOption map(SceneOption option, RequirementTester tester) {
        tester.setRequirement(option.getRequirement());
        return SessionOption.builder()
                .text(option.getText())
                .nextKey(option.getNextKey())
                .disabled(!tester.isSatisfied())
                .build();
    }
}
