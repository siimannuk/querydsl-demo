package com.siimannuk.querydsldemo.model.superhero;

import java.util.Optional;
import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface EntityRepository<T>
        extends JpaRepository<T, Long>,
                QuerydslPredicateExecutor<T> {

    default Optional<T> find(Long id) {
        return Optional.ofNullable(getOne(id));
    }

    default Optional<T> find(Predicate predicate) {
        return findOne(predicate);
    }
}
