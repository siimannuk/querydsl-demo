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
    private EntityManager entityManager;

    protected AbstractEntityService(EntityRepository<T> repo) {
        this.repository = repo;
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

    protected JPAUpdateClause update(EntityPath<?> entity) {
        return new JPAUpdateClause(this.entityManager, entity);
    }

    protected JPADeleteClause delete(EntityPath<?> entity) {
        return new JPADeleteClause(this.entityManager, entity);
    }

    protected JPAQuery<T> query() {
        return new JPAQuery<>(this.entityManager);
    }
}
