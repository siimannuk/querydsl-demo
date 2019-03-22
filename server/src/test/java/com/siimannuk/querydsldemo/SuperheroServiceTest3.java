package com.siimannuk.querydsldemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SuperheroServiceTest3 extends AbstractTests {

    @Test
    public void updateName() {
        log.info(
            Long.toString(this.superheroes.updateName(96L, "Black Knight IIIX"))
        );
    }
}
