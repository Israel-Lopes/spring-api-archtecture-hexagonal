package com.hexagonal.architecture.app.core.repository;

import com.hexagonal.architecture.app.core.entity.Paged;
import com.hexagonal.architecture.app.core.entity.ProductEntity;

public interface ProductRepository {
    Paged<ProductEntity> findAllPaged(Integer page, Integer itemsPerPage);

    ProductEntity findById(Long id);

    void save(ProductEntity product);
}
