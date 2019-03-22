package com.siimannuk.querydsldemo;

import com.siimannuk.querydsldemo.model.superhero.SuperheroService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@Transactional
public class SuperheroServiceTest3 {
    @Autowired
    private SuperheroService superheroes;

    @After
    public void printSqlStatement() {
        Util.printSqlStatement();
    }

    @Test
    public void updateName() {
        log.info(
            Long.toString(this.superheroes.updateName(96L, "Black Knight IIIX"))
        );
    }
}
