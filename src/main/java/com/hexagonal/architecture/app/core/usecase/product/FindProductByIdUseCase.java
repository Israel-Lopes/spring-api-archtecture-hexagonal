package com.hexagonal.architecture.app.core.usecase.product;

import com.hexagonal.architecture.app.core.entity.ProductEntity;
import com.hexagonal.architecture.app.core.exception.NotFoundException;
import com.hexagonal.architecture.app.core.repository.ProductRepository;

public class FindProductByIdUseCase {
  private final ProductRepository repository;
  public FindProductByIdUseCase(ProductRepository repository) {
    this.repository = repository;
  }
  public ProductEntity execute(long code) {
    ProductEntity product = this.repository.findById(code);
    if (product == null) {
      throw new NotFoundException("Product code " + code + " not found");
    }
    return product;
  }
}