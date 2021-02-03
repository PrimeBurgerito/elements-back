package com.elements.elementsdomain.shared.requirement;

import com.querydsl.core.annotations.QueryEmbedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.util.List;

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

    @QueryEmbedded
    private PropertiesRequirement properties;
}
