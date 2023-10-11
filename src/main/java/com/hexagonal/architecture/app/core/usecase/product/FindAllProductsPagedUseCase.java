package com.hexagonal.architecture.app.core.usecase.product;

import com.hexagonal.architecture.app.core.dtos.Paged;
import com.hexagonal.architecture.app.core.dtos.ProductDTO;
import com.hexagonal.architecture.app.core.repository.ProductRepository;

public class FindAllProductsPagedUseCase {
  private final ProductRepository repository;
  public FindAllProductsPagedUseCase(ProductRepository repository) {
    this.repository = repository;
  }
  public Paged<ProductDTO> execute(Integer page, Integer itemsPerPage) {
    return repository.findAllPaged(page, itemsPerPage);
  }
}