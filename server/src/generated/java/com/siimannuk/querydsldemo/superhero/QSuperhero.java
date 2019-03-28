package com.siimannuk.querydsldemo.superhero;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSuperhero is a Querydsl query type for Superhero
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSuperhero extends EntityPathBase<Superhero> {

    private static final long serialVersionUID = -1795990172L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSuperhero superhero = new QSuperhero("superhero");

    public final QAlignment alignment;

    public final StringPath eyeColor = createString("eyeColor");

    public final StringPath gender = createString("gender");

    public final StringPath hairColor = createString("hairColor");

    public final NumberPath<Double> height = createNumber("height", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QPublisher publisher;

    public final QRace race;

    public final StringPath skinColor = createString("skinColor");

    public final SetPath<Superpower, QSuperpower> superpowers = this.<Superpower, QSuperpower>createSet("superpowers", Superpower.class, QSuperpower.class, PathInits.DIRECT2);

    public final NumberPath<Double> weight = createNumber("weight", Double.class);

    public QSuperhero(String variable) {
        this(Superhero.class, forVariable(variable), INITS);
    }

    public QSuperhero(Path<? extends Superhero> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSuperhero(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSuperhero(PathMetadata metadata, PathInits inits) {
        this(Superhero.class, metadata, inits);
    }

    public QSuperhero(Class<? extends Superhero> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.alignment = inits.isInitialized("alignment") ? new QAlignment(forProperty("alignment")) : null;
        this.publisher = inits.isInitialized("publisher") ? new QPublisher(forProperty("publisher")) : null;
        this.race = inits.isInitialized("race") ? new QRace(forProperty("race")) : null;
    }

}

