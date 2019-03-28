package com.siimannuk.querydsldemo;

import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.siimannuk.querydsldemo.Util.print;
import static com.siimannuk.querydsldemo.superhero.SuperheroService.*;

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
        Predicate pred = hasPowers(
            "Super Speed", "Fire Resistance", "Plant Control"
        );

        print(this.superheroes.findAll(pred));
    }
}
