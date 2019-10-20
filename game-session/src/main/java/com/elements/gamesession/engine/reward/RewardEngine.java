package com.elements.gamesession.engine.reward;

import com.elements.elementsdomain.composite.character.CharacterStatistics;
import com.elements.elementsdomain.composite.reward.*;
import com.elements.gamesession.session.GameSession;

import java.util.Map;
import java.util.Set;

public class RewardEngine {
    private RewardEngine() {
    }

    public static void collectRewards(GameSession session, Reward reward) {
        CharacterStatistics statistics = session.getGameState().getCharacter().getStatistics();
        reward.getProperties().forEach(r -> collectPropertyReward(statistics.getProperties(), r));
        reward.getObjectives().forEach(r -> collectObjectiveReward(statistics.getObjectives(), r));
        reward.getAttributes().forEach(r -> collectAttributeReward(statistics.getAttributes(), r));

        session.updateClientCharacterStatistics();
    }

    private static void collectPropertyReward(Map<String, String> properties, PropertyReward reward) {
        if (reward.getType().equals(RewardType.ADD)) {
            properties.put(reward.getPropertyKey(), reward.getValue());
        } else if (reward.getType().equals(RewardType.REMOVE)) {
            properties.remove(reward.getPropertyKey(), reward.getValue());
        }
    }

    private static void collectObjectiveReward(Set<String> objectives, ObjectiveReward reward) {
        if (reward.getType().equals(RewardType.ADD)) {
            objectives.add(reward.getObjectiveKey());
        } else if (reward.getType().equals(RewardType.REMOVE)) {
            objectives.remove(reward.getObjectiveKey());
        }
    }

    private static void collectAttributeReward(Map<String, Float> attributes, AttributeReward reward) {
        float value = reward.getValue();
        if (attributes.containsKey(reward.getAttributeKey())) {
            attributes.compute(reward.getAttributeKey(), (s, v) -> v != null ? v + value : value);
        } else {
            attributes.put(reward.getAttributeKey(), value);
        }
    }
}
