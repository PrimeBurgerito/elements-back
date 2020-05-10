package com.elements.gamesession.engine.reward;

import com.elements.elementsdomain.shared.character.CharacterProperties;
import com.elements.elementsdomain.shared.property.NumericProperty;
import com.elements.elementsdomain.shared.property.StringProperty;
import com.elements.gamesession.session.GameSession;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@UtilityClass
public class RewardEngine {

    public void collectRewards(GameSession session, Reward reward) {
        CharacterProperties statistics = session.getGameState().getCharacter().getProperties();
        reward.getProperties().forEach(collectStringPropertyReward(statistics.getStringProperties()));
        reward.getObjectives().forEach(r -> collectObjectiveReward(Collections.emptySet(), r));
        reward.getAttributes().forEach(collectNumericPropertyReward(statistics.getNumericProperties()));

        session.updateGameStateResourceCharacterProperties();
    }

    private Consumer<StringPropertyReward> collectStringPropertyReward(List<StringProperty> properties) {
        return reward -> {
            Optional<StringProperty> property = properties.stream()
                    .filter(p -> p.getKey().equals(reward.getPropertyKey()))
                    .findFirst();

            if (property.isPresent()) {
                if (reward.getType().equals(RewardType.ADD)) {
                    property.get().setValue(reward.getValue());
                } else if (reward.getType().equals(RewardType.REMOVE)) {
                    property.get().getValue().removeAll(reward.getValue());
                }
            }
        };
    }

    private Consumer<NumericPropertyReward> collectNumericPropertyReward(List<NumericProperty> properties) {
        return reward -> {
            Optional<NumericProperty> property = properties.stream()
                    .filter(p -> p.getKey().equals(reward.getPropertyKey()))
                    .findFirst();

            if (property.isPresent()) {
                if (reward.getType().equals(RewardType.ADD)) {
                    property.get().setValue(property.get().getValue() + reward.getValue());
                } else if (reward.getType().equals(RewardType.REMOVE)) {
                    property.get().setValue(property.get().getValue() - reward.getValue());
                }
            }
        };
    }

    private void collectObjectiveReward(Set<String> objectives, ObjectiveReward reward) {
        if (reward.getType().equals(RewardType.ADD)) {
            objectives.add(reward.getObjectiveKey());
        } else if (reward.getType().equals(RewardType.REMOVE)) {
            objectives.remove(reward.getObjectiveKey());
        }
    }
}
