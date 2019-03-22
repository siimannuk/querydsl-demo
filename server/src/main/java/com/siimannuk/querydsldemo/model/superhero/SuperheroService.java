package com.siimannuk.querydsldemo.model.superhero;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.siimannuk.querydsldemo.model.superhero.QSuperhero.superhero;

@Service
@Transactional
public class SuperheroService extends AbstractEntityService<Superhero> {
    @Autowired
    public SuperheroService(SuperheroRepository repository) {
        super(repository);
    }

    // -------------------------------------------------------------------------

    public long updateName(long heroId, String name) {
        return update(superhero)
            .set(superhero.name, name)
            .where(superhero.id.eq(heroId))
            .execute();
    }



















    // -------------------------------------------------------------------------

    public static BooleanExpression byName(String name) {
        return superhero.name.eq(name);
    }

    public static BooleanExpression byNameLike(String name) {
        return superhero.name.like(name);
    }

    public static BooleanExpression isHuman() {
        return superhero.race.name.eq("Human");
    }

    public static BooleanExpression isMale() {
        return superhero.gender.eq("Male");
    }

    public static BooleanExpression isGood() {
        return superhero.alignment.name.eq("good");
    }

    public static BooleanExpression isMarvelHero() {
        return superhero.publisher.name.eq("Marvel Comics");
    }

    public static BooleanExpression hasPowers(String... powerName) {
        return superhero.superpowers.any().name.in(powerName);
    }
}
