package com.elements.gamesession.session.event.domain;

import com.elements.elementsdomain.event.scene.Scene;
import com.elements.elementsdomain.event.scene.SceneOption;
import com.elements.elementsdomain.event.scene.SceneType;
import com.elements.elementsdomain.gamestate.character.CharacterStatistics;
import com.elements.gamesession.requirementengine.RequirementTester;
import com.elements.gamesession.requirementengine.RequirementTesterUserInfo;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SessionEventMapper {

    private SessionEventMapper() {
    }

    public static SessionEvent map(Scene scene, CharacterStatistics statistics) {
        if (scene == null) {
            return null;
        }
        SessionEvent sessionEvent = getNewSessionEvent(scene);
        if (scene.getType() == SceneType.OPTION) {
            RequirementTester tester = getOptionRequirementTester(statistics);
            sessionEvent.setOptions(mapSceneOptions(scene, tester));
        }
        return sessionEvent;
    }

    private static SessionEvent getNewSessionEvent(Scene scene) {
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

    private static List<SessionOption> mapSceneOptions(Scene scene, RequirementTester tester) {
        return scene.getOptions().stream().map(o -> map(o, tester)).collect(toList());
    }

    private static SessionOption map(SceneOption option, RequirementTester tester) {
        tester.setRequirement(option.getRequirement());
        return SessionOption.builder()
                .text(option.getText())
                .disabled(!tester.isSatisfied())
                .build();
    }
}
