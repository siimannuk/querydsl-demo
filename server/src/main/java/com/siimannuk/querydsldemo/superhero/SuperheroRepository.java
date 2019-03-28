package com.siimannuk.querydsldemo.superhero;

import com.siimannuk.querydsldemo.EntityRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SuperheroRepository extends EntityRepository<Superhero> {
}
