package com.elements.gamesession.session.crud.event.domain;

import com.elements.elementsdomain.document.event.scene.Scene;
import com.elements.elementsdomain.document.event.scene.SceneImage;
import com.elements.elementsdomain.document.event.scene.option.Option;
import com.elements.elementsdomain.document.event.scene.option.SceneOption;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.gamesession.engine.requirement.RequirementTester;
import com.elements.gamesession.engine.requirement.RequirementTesterInput;
import lombok.experimental.UtilityClass;

import java.util.List;

import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.toList;

@UtilityClass
class SceneStateMapper {

    SceneState map(Scene scene) {
        if (scene == null) {
            return null;
        }
        return getNewSessionEvent(scene);
    }

    SceneState map(SceneOption scene, CharacterProperties statistics) {
        if (scene == null) {
            return null;
        }
        SceneState sceneState = getNewSessionEvent(scene);
        RequirementTester tester = getOptionRequirementTester(statistics);
        sceneState.setOptions(mapSceneOptions(scene, tester));
        return sceneState;
    }

    private SceneState getNewSessionEvent(SceneImage scene) {
        return SceneState.builder()
                .text(scene.getText())
                .image(scene.getImage())
                .type(scene.getType())
                .build();
    }

    private RequirementTester getOptionRequirementTester(CharacterProperties statistics) {
        RequirementTesterInput userInfo = RequirementTesterInput.builder()
                .numericProperties(statistics.getNumericPropertyKeyToValue())
                .stringProperties(statistics.getStringPropertyKeyToValue())
                .objectives(emptySet()) // TODO
                .build();
        return new RequirementTester(userInfo);
    }

    private List<SceneStateOption> mapSceneOptions(SceneOption scene, RequirementTester tester) {
        return scene.getOptions().stream().map(o -> map(o, tester)).collect(toList());
    }

    private SceneStateOption map(Option option, RequirementTester tester) {
        return SceneStateOption.builder()
                .text(option.getText())
                .disabled(!tester.isSatisfied(option.getRequirement()))
                .build();
    }
}
