package com.siimannuk.querydsldemo.superhero;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAlignment is a Querydsl query type for Alignment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlignment extends EntityPathBase<Alignment> {

    private static final long serialVersionUID = 304149842L;

    public static final QAlignment alignment = new QAlignment("alignment");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QAlignment(String variable) {
        super(Alignment.class, forVariable(variable));
    }

    public QAlignment(Path<? extends Alignment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlignment(PathMetadata metadata) {
        super(Alignment.class, metadata);
    }

}

