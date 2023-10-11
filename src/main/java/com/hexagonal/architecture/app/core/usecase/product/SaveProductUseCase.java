package com.hexagonal.architecture.app.core.usecase.product;

import com.hexagonal.architecture.app.core.entity.ProductEntity;
import com.hexagonal.architecture.app.core.exception.DuplicatedException;
import com.hexagonal.architecture.app.core.repository.ProductRepository;

public class SaveProductUseCase {
    private final ProductRepository productRepository;
    public SaveProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void execute(ProductEntity product) {
        long productCode = product.getId();
        if (productRepository.findById(productCode) != null) {
            throw new DuplicatedException("Product code " + productCode + " already exists");
        }
        this.productRepository.save(product);
    }
}
