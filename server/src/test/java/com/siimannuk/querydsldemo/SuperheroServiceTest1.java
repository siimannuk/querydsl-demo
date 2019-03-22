package com.siimannuk.querydsldemo;

import com.querydsl.core.types.Predicate;
import com.siimannuk.querydsldemo.model.superhero.SuperheroService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.siimannuk.querydsldemo.model.superhero.QSuperhero.superhero;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@Transactional
public class SuperheroServiceTest1 {
    @Autowired
    private SuperheroService superheroes;

    @After
    public void printSqlStatement() {
        Util.printSqlStatement();
    }

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

        this.superheroes.findAll(pred).forEach(Util::print);

        //PageRequest page = PageRequest.of(1, 3);
        //this.superheroes.findAll(pred, page).forEach(Util::print);
    }

    @Test
    public void findAllBySuperpowers() {
        Predicate pred = superhero.superpowers.any().name.eq("Super Speed");

        this.superheroes.findAll(pred).forEach(Util::print);
    }

    @Test
    public void findByNameLike() {
        Predicate pred = superhero.name.like("Super%");

        this.superheroes.findAll(pred).forEach(Util::print);
    }

    @Test
    public void findByWeight() {
        Predicate pred = superhero.weight.between(0, 50);

        this.superheroes.findAll(pred).forEach(Util::print);
    }

    @Test
    public void findOrdered() {
        Predicate pred = null;

        this.superheroes.findAll(pred, superhero.name.asc())
            .forEach(Util::print);
    }
}
