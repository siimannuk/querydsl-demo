package com.siimannuk.querydsldemo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.siimannuk.querydsldemo.model.superhero.SuperheroService;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractTests {
    @Autowired
    SuperheroService superheroes;

    @PersistenceContext
    EntityManager entityManager;

    @After
    public void printSqlStatement() {
        Util.printSqlStatement();
    }
}
