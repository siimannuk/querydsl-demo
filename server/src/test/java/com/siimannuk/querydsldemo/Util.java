package com.siimannuk.querydsldemo;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siimannuk.querydsldemo.superhero.Superhero;
import com.siimannuk.querydsldemo.superhero.SuperheroDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@Slf4j
final class Util {
    private static final ObjectMapper OM = mapper();

    private Util() {
    }

    static void print(List<Superhero> superheroes) {
        superheroes.stream().map(Superhero::toDto).forEach(Util::print);
    }

    @SneakyThrows
    static void print(Superhero superhero) {
        print(superhero.toDto());
    }

    @SneakyThrows
    static void print(SuperheroDto superhero) {
        log.info(
            OM.writerWithDefaultPrettyPrinter().writeValueAsString(superhero)
        );
    }

    @SneakyThrows
    static void printSqlStatement() {
        log.info("\nEXECUTED QUERY:");
        try (InputStream in =
                 Files.newInputStream(Paths.get("build/statements.sql"))) {
            // just pretty print the first non-empty line as SQL
            IOUtils.readLines(in, StandardCharsets.UTF_8).stream()
                .filter(l -> !l.isEmpty())
                .findFirst()
                .ifPresent(l -> log.info(new BasicFormatterImpl().format(l)));
        }
        log.info("\n");
    }

    private static ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, ANY);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }
}
