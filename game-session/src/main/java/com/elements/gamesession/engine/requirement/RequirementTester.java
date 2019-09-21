package com.elements.gamesession.engine.requirement;

import com.elements.elementsdomain.requirement.Requirement;
import com.elements.elementsdomain.requirement.Timing;
import lombok.Data;
import org.springframework.data.util.Pair;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static org.apache.commons.lang3.Range.between;

@Data
public class RequirementTester {
    private Requirement requirement;
    private RequirementTesterUserInfo userInfo;

    public boolean isSatisfied() {
        return requirement == null || (
                isCorrectLocation() &&
                        areAttributesSatisfied() &&
                        arePropertiesSatisfied() &&
                        areObjectivesSatisfied() &&
                        isCorrectTiming()
        );
    }

    private boolean isCorrectLocation() {
        return requirement.getLocationId() == null || requirement.getLocationId().equals(userInfo.getLocationId());
    }

    private boolean areObjectivesSatisfied() {
        return (userInfo.getObjectives() == null && requirement.getObjectives() == null) ||
                userInfo.getObjectives().containsAll(requirement.getObjectives());
    }

    private boolean areAttributesSatisfied() {
        Map<String, Pair<Float, Float>> attributes = requirement.getAttributes();
        return attributes == null || attributes.isEmpty() ||
                attributes.entrySet().stream().allMatch(this::isAttributeSatisfied);
    }

    private boolean isAttributeSatisfied(Entry<String, Pair<Float, Float>> keyToAttribute) {
        String key = keyToAttribute.getKey();
        Pair<Float, Float> req = keyToAttribute.getValue();
        Float userAttr = userInfo.getAttributes().get(key);
        return userInfo.getAttributes().containsKey(key) && between(req.getFirst(), req.getSecond()).contains(userAttr);
    }

    private boolean arePropertiesSatisfied() {
        Map<String, Set<String>> properties = requirement.getProperties();
        return properties == null || properties.isEmpty() ||
                properties.entrySet().stream().allMatch(this::isPropertySatisfied);
    }

    private boolean isPropertySatisfied(Entry<String, Set<String>> keyToProperty) {
        String key = keyToProperty.getKey();
        Map<String, String> userProperties = userInfo.getProperties();
        return userProperties.containsKey(key) && keyToProperty.getValue().contains(userProperties.get(key));
    }

    private boolean isCorrectTiming() {
        Timing timing = requirement.getTiming();
        return timing == null || isTimingEmpty(timing);
    }

    private static boolean isTimingEmpty(Timing timing) {
        return timing.getMonthDays().length == 0 &&
                timing.getWeekDays().length == 0 &&
                timing.getMonths().isEmpty() &&
                timing.getTime().isEmpty();
    }
}
