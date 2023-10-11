package com.hexagonal.architecture.app.core.service;

import com.hexagonal.architecture.app.core.dtos.Paged;
import com.hexagonal.architecture.app.core.dtos.ProductDTO;
import com.hexagonal.architecture.app.core.usecase.product.FindAllProductsPagedUseCase;
import com.hexagonal.architecture.app.core.usecase.product.FindProductByIdUseCase;
import com.hexagonal.architecture.app.core.usecase.product.SaveProductUseCase;

public class ProductService {
    private final FindAllProductsPagedUseCase findAllProductsPagedUseCase;
    private final FindProductByIdUseCase findProductByIdUseCase;
    private final SaveProductUseCase saveProductUseCase;
    public ProductService(
            FindProductByIdUseCase findProductByIdUseCase,
            FindAllProductsPagedUseCase findAllProductsPagedUseCase,
            SaveProductUseCase saveProductUseCase
    ) {
        this.findProductByIdUseCase = findProductByIdUseCase;
        this.findAllProductsPagedUseCase = findAllProductsPagedUseCase;
        this.saveProductUseCase = saveProductUseCase;
    }
    public ProductDTO findProductById(Long id) {
        return findProductByIdUseCase.execute(id);
    }
    public Integer findProductStockById(Long id) {
        return findProductById(id).getStock();
    }
    public Paged<ProductDTO> findAllProductPaged(Integer page, Integer itemsPerPage) {
        return findAllProductsPagedUseCase.execute(page, itemsPerPage);
    }
    public void save(ProductDTO product) {
        saveProductUseCase.execute(product);
    }
}
