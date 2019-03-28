package com.siimannuk.querydsldemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityRepository<T>
        extends JpaRepository<T, Long>,
                QuerydslPredicateExecutor<T> {
}
