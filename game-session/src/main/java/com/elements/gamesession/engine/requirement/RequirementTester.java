package com.elements.gamesession.engine.requirement;

import com.elements.elementsdomain.shared.requirement.Requirement;
import com.elements.elementsdomain.shared.requirement.Requirement.PropertiesRequirement;
import com.elements.elementsdomain.shared.requirement.Timing;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.lang3.Range.between;

@RequiredArgsConstructor
public class RequirementTester {
    private final RequirementTesterInput userInfo;

    public boolean isSatisfied(@Nullable Requirement requirement) {
        return requirement == null
                || (isCorrectLocation(requirement.getLocationIds())
                && arePropertiesSatisfied(requirement.getProperties())
                && areObjectivesSatisfied(requirement.getObjectives())
                && isCorrectTiming(requirement.getTiming()));
    }

    private boolean isCorrectLocation(@Nullable List<String> locationIds) {
        return locationIds == null || locationIds.isEmpty() || locationIds.contains(userInfo.getLocationId());
    }

    private boolean arePropertiesSatisfied(@Nullable PropertiesRequirement properties) {
        return properties == null
                || (areNumericPropertiesSatisfied(properties.getNumericProperties())
                && areStringPropertiesSatisfied(properties.getStringProperties()));
    }

    private boolean areObjectivesSatisfied(@Nullable List<String> requiredObjectives) {
        return requiredObjectives == null || userInfo.getObjectives().containsAll(requiredObjectives);
    }

    private boolean areNumericPropertiesSatisfied(@Nullable Map<String, Pair<Float, Float>> requiredProperties) {
        return requiredProperties == null
                || requiredProperties.isEmpty()
                || requiredProperties.entrySet().stream().allMatch(this::isUserNumericPropertySatisfied);
    }

    private boolean isUserNumericPropertySatisfied(Entry<String, Pair<Float, Float>> requiredPropertyEntry) {
        String key = requiredPropertyEntry.getKey();
        Pair<Float, Float> req = requiredPropertyEntry.getValue();
        Float userAttr = userInfo.getNumericProperties().get(key);
        return userInfo.getNumericProperties().containsKey(key) && between(req.getFirst(), req.getSecond()).contains(userAttr);
    }

    private boolean areStringPropertiesSatisfied(@Nullable Map<String, Set<String>> requiredProperties) {
        return requiredProperties == null
                || requiredProperties.isEmpty()
                || requiredProperties.entrySet().stream().allMatch(this::isUserStringPropertySatisfied);
    }

    private boolean isUserStringPropertySatisfied(Entry<String, Set<String>> requiredPropertyEntry) {
        String key = requiredPropertyEntry.getKey();
        Map<String, List<String>> userProperties = userInfo.getStringProperties();
        return userProperties.containsKey(key) && requiredPropertyEntry.getValue().containsAll(userProperties.get(key));
    }

    private boolean isCorrectTiming(Timing requiredTiming) {
        return requiredTiming == null || isTimingEmpty(requiredTiming);
    }

    private static boolean isTimingEmpty(Timing timing) {
        return timing.getMonthDays().length == 0 &&
                timing.getWeekDays().length == 0 &&
                timing.getMonths().isEmpty() &&
                timing.getTime().isEmpty();
    }
}
