package com.siimannuk.querydsldemo.superhero;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSuperpower is a Querydsl query type for Superpower
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSuperpower extends EntityPathBase<Superpower> {

    private static final long serialVersionUID = 166570203L;

    public static final QSuperpower superpower = new QSuperpower("superpower");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QSuperpower(String variable) {
        super(Superpower.class, forVariable(variable));
    }

    public QSuperpower(Path<? extends Superpower> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSuperpower(PathMetadata metadata) {
        super(Superpower.class, metadata);
    }

}

