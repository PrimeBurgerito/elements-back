package com.elements.elementsdomain.shared.requirement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.util.Pair;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Requirement implements Serializable {
    private static final long serialVersionUID = -1465864466408195808L;

    @Indexed(sparse = true)
    private List<String> locationIds;
    private Timing timing;
    private List<String> objectives;
    private PropertiesRequirement properties;

    @Data
    @Builder
    public static class PropertiesRequirement implements Serializable {
        private static final long serialVersionUID = 3495875495505930239L;

        private Map<String, Set<String>> stringProperties;
        private Map<String, Pair<Float, Float>> numericProperties;
    }
}
