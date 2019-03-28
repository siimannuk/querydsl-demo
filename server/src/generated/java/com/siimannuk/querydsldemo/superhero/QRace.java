package com.siimannuk.querydsldemo.superhero;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRace is a Querydsl query type for Race
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRace extends EntityPathBase<Race> {

    private static final long serialVersionUID = -1856287230L;

    public static final QRace race = new QRace("race");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QRace(String variable) {
        super(Race.class, forVariable(variable));
    }

    public QRace(Path<? extends Race> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRace(PathMetadata metadata) {
        super(Race.class, metadata);
    }

}

