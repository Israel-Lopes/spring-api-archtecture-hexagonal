package com.hexagonal.architecture.app.infrastructure.factory;

import com.hexagonal.architecture.app.adapters.repository.model.adapter.ProductModelAdapter;
import com.hexagonal.architecture.app.core.repository.ProductRepository;
import com.hexagonal.architecture.app.core.service.ProductService;
import com.hexagonal.architecture.app.core.usecase.product.FindAllProductsPagedUseCase;
import com.hexagonal.architecture.app.core.usecase.product.FindProductByIdUseCase;
import com.hexagonal.architecture.app.core.usecase.product.SaveProductUseCase;
import com.hexagonal.architecture.app.infrastructure.database.bridge.ProductRepositoryBridge;
import com.hexagonal.architecture.app.infrastructure.database.springdata.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductServiceFactory {
    private final ProductJpaRepository productRepositoryImpl;
    @Autowired
    public ProductServiceFactory(ProductJpaRepository productRepositoryImpl) {
        this.productRepositoryImpl = productRepositoryImpl;
    }
    @Bean
    @Autowired
    public ProductService createProductService(ProductRepository repository) {
        FindProductByIdUseCase findProductByIdUseCase = new FindProductByIdUseCase(repository);
        FindAllProductsPagedUseCase findAllProductsPagedUseCase = new FindAllProductsPagedUseCase(
                repository);
        SaveProductUseCase saveProductUseCase = new SaveProductUseCase(repository);

        return new ProductService(findProductByIdUseCase, findAllProductsPagedUseCase,
                saveProductUseCase);
    }
    @Bean
    public ProductRepository createProductRepository() {
        ProductModelAdapter modelAdapter = new ProductModelAdapter();
        ProductRepositoryBridge repository = new ProductRepositoryBridge(productRepositoryImpl,
                modelAdapter);
        return repository;
    }
}