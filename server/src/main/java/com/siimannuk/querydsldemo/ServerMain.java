package com.siimannuk.querydsldemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Configuration
@ComponentScan("com.siimannuk.querydsldemo")
@EnableJpaRepositories
@EnableTransactionManagement
@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class ServerMain {
    public static void main(String... args) {
        //...
    }
}
