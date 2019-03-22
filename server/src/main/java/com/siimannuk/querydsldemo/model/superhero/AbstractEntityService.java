package com.siimannuk.querydsldemo.model.superhero;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class AbstractEntityService<T> {
    @Getter(AccessLevel.PROTECTED)
    private final EntityRepository<T> repository;

    @PersistenceContext
    private EntityManager em;

    protected AbstractEntityService(EntityRepository<T> r) {
        this.repository = r;
    }

    public Page<T> findAll(Predicate predicate, Pageable pageable) {
        return repository().findAll(predicate, pageable);
    }

    public List<T> findAll(Predicate predicate) {
        return (List<T>) repository().findAll(predicate);
    }

    public List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
        return (List<T>) repository().findAll(predicate, orders);
    }

    public List<T> findAll() {
        return repository().findAll();
    }

    public Optional<T> find(Predicate predicate) {
        return repository().find(predicate);
    }

    public JPAUpdateClause update(EntityPath<?> entity) {
        return new JPAUpdateClause(this.em, entity);
    }

    public JPADeleteClause delete(EntityPath<?> entity) {
        return new JPADeleteClause(this.em, entity);
    }

    public JPAQuery<T> query() {
        return new JPAQuery<>(this.em);
    }
}
