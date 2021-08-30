package com.elements.elementsdomain.document.container;

import com.elements.elementsdomain.document.RealmDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Document
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class KeyContainer extends RealmDocument {
    @Indexed(unique = true)
    private String key;
    @NotEmpty
    private Set<Key> keys;
}
