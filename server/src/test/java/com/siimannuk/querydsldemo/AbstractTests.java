package com.siimannuk.querydsldemo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.siimannuk.querydsldemo.superhero.SuperheroService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class AbstractTests {
    @Autowired
    SuperheroService superheroes;

    @PersistenceContext
    EntityManager entityManager;

    @Before
    public void beforeTest() {
        log.info("\n\n");
    }

    @After
    public void printSqlStatement() {
        Util.printSqlStatement();
    }
}
