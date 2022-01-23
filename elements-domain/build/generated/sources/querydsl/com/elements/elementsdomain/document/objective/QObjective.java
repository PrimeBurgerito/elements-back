package com.elements.elementsdomain.document.objective;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QObjective is a Querydsl query type for Objective
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QObjective extends EntityPathBase<Objective> {

    private static final long serialVersionUID = -1042801222L;

    public static final QObjective objective = new QObjective("objective");

    public final com.elements.elementsdomain.document.QRealmDocument _super = new com.elements.elementsdomain.document.QRealmDocument(this);

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    //inherited
    public final StringPath realmId = _super.realmId;

    public final StringPath value = createString("value");

    public QObjective(String variable) {
        super(Objective.class, forVariable(variable));
    }

    public QObjective(Path<? extends Objective> path) {
        super(path.getType(), path.getMetadata());
    }

    public QObjective(PathMetadata metadata) {
        super(Objective.class, metadata);
    }

}

