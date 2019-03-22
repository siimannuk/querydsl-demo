package com.siimannuk.querydsldemo;

import com.querydsl.core.types.Predicate;
import com.siimannuk.querydsldemo.model.superhero.SuperheroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.siimannuk.querydsldemo.Util.print;
import static com.siimannuk.querydsldemo.model.superhero.SuperheroService.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SuperheroServiceTest2 extends AbstractTests {

    @Test
    public void findByName() {
        print(this.superheroes.findAll(byName("Thanos")));
    }

    @Test
    public void findAllGoodMarvelMaleHumans() {
        print(
            this.superheroes.findAll(
                isHuman()
                    .and(isGood())
                    .and(isMale())
                    .and(isMarvelHero())
            )
        );
    }

    @Test
    public void findAllBySuperpowers() {
        Predicate pred = SuperheroService.hasPowers(
            "Super Speed", "Fire Resistance", "Plant Control"
        );

        print(this.superheroes.findAll(pred));
    }
}
