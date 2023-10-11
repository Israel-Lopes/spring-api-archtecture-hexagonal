package com.hexagonal.architecture.app.core.usecase.product;

import com.hexagonal.architecture.app.core.entity.Paged;
import com.hexagonal.architecture.app.core.entity.ProductEntity;
import com.hexagonal.architecture.app.core.repository.ProductRepository;

public class FindAllProductsPagedUseCase {
  private final ProductRepository repository;
  public FindAllProductsPagedUseCase(ProductRepository repository) {
    this.repository = repository;
  }
  public Paged<ProductEntity> execute(Integer page, Integer itemsPerPage) {
    return repository.findAllPaged(page, itemsPerPage);
  }
}