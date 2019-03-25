package com.siimannuk.querydsldemo;

import java.util.List;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.siimannuk.querydsldemo.Util.print;
import static com.siimannuk.querydsldemo.model.superhero.QPublisher.publisher;
import static com.siimannuk.querydsldemo.model.superhero.QSuperhero.superhero;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SuperheroServiceTest1 extends AbstractTests {

    @Test
    public void findThanos() {
        Predicate pred = superhero.name.eq("Thanos");

        this.superheroes.findAll(pred).forEach(Util::print);
    }

    @Test
    public void findAllHumans() {
        Predicate pred = superhero.race.name.eq("Human")
            .and(superhero.gender.eq("Male"))
            .and(superhero.alignment.name.eq("good"))
            .and(superhero.publisher.name.eq("Marvel Comics"));

        print(this.superheroes.findAll(pred));

        //PageRequest page = PageRequest.of(1, 3);
        //print(this.superheroes.findAll(pred, page).forEach(Util::print);
    }

    @Test
    public void findAllBySuperpowers() {
        Predicate pred = superhero.superpowers.any().name.eq("Super Speed");

        print(this.superheroes.findAll(pred));
    }

    @Test
    public void findByNameLike() {
        Predicate pred = superhero.name.like("Super%");

        print(this.superheroes.findAll(pred));
    }

    @Test
    public void findByWeight() {
        Predicate pred = superhero.weight.between(0, 50);

        print(this.superheroes.findAll(pred));
    }

    @Test
    public void findOrdered() {
        Predicate pred = null;

        print(this.superheroes.findAll(pred, superhero.name.asc()));
    }

    @Test
    public void findWithSubquery() {
        Predicate pred = superhero.publisher.id.eq(
            new JPAQuery<>(this.entityManager)
                .from(publisher)
                .select(publisher.id)
                .where(publisher.name.eq("DC Comics"))
        );

        print(this.superheroes.findAll(pred));
    }

    @Test
    public void findTheSumOfWeight() {
        Double totalWeight = new JPAQuery<>(this.entityManager)
            .from(superhero)
            .where(superhero.weight.gt(0.0D))
            .select(superhero.weight.sum())
            .fetch()
            .get(0);

        log.info("Weight: {}", totalWeight);
    }

    @Test
    public void findNumberHeroesPerRace() {
        List<Tuple> result = new JPAQuery<>(this.entityManager)
            .from(superhero)
            .groupBy(superhero.race.name)
            .select(superhero.race.name, superhero.count())
            .fetch();

        result.forEach(t -> log.info("{}", t));
    }
}
