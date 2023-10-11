package com.hexagonal.architecture.app.infrastructure.database.springdata;

import com.hexagonal.architecture.app.adapters.repository.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
