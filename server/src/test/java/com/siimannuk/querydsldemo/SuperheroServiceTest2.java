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

import static com.siimannuk.querydsldemo.model.superhero.SuperheroService.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@Transactional
public class SuperheroServiceTest2 {
    @Autowired
    private SuperheroService superheroes;

    @After
    public void printSqlStatement() {
        Util.printSqlStatement();
    }

    @Test
    public void findByName() {
        this.superheroes.findAll(byName("Thanos")).forEach(Util::print);
    }

    @Test
    public void findAllGoodMarvelMaleHumans() {
        this.superheroes
            .findAll(isHuman().and(isGood()).and(isMale()).and(isMarvelHero()))
            .forEach(Util::print);
    }

    @Test
    public void findAllBySuperpowers() {
        Predicate pred = SuperheroService.hasPowers(
            "Super Speed", "Fire Resistance", "Plant Control"
        );

        this.superheroes.findAll(pred).forEach(Util::print);
    }
}
