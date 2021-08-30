package com.elements.elementsdomain.document.item;

import com.elements.elementsdomain.document.RealmDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@SuperBuilder
@NoArgsConstructor
@Document(collection = "items")
@EqualsAndHashCode(callSuper = true)
public abstract class Item extends RealmDocument {
    private String name;

    public abstract ItemType getType();
}
