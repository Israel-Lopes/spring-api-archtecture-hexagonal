package com.hexagonal.architecture.app.infrastructure.database.bridge;

import com.hexagonal.architecture.app.adapters.repository.adapter.ProductRepositoryAdapter;
import com.hexagonal.architecture.app.adapters.repository.model.ProductModel;
import com.hexagonal.architecture.app.adapters.repository.model.adapter.ProductModelAdapter;
import com.hexagonal.architecture.app.infrastructure.database.springdata.ProductJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class ProductRepositoryBridge extends ProductRepositoryAdapter {
    private final ProductJpaRepository repository;
    public ProductRepositoryBridge(ProductJpaRepository repository,
                                   ProductModelAdapter modelAdapter) {
        super(modelAdapter);
        this.repository = repository;
    }
    @Override
    protected List<ProductModel> findAllBridge() {
        return repository.findAll();
    }
    @Override
    protected Page<ProductModel> findAllPagedBridge(Integer page, Integer itemsPerPage) {
        return repository.findAll(PageRequest.of(page - 1, itemsPerPage));
    }
    @Override
    protected ProductModel findByIdBridge(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    protected void saveBridge(ProductModel productModel) {
        repository.save(productModel);
    }
}
