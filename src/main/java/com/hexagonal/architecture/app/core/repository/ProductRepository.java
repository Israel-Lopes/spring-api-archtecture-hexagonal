package com.hexagonal.architecture.app.core.repository;

import com.hexagonal.architecture.app.core.dtos.Paged;
import com.hexagonal.architecture.app.core.dtos.ProductDTO;

public interface ProductRepository {
    Paged<ProductDTO> findAllPaged(Integer page, Integer itemsPerPage);

    ProductDTO findById(Long id);

    void save(ProductDTO product);
}
