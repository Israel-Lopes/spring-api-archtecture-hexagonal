package com.hexagonal.architecture.app.adapters.repository.adapter;

import com.hexagonal.architecture.app.adapters.repository.model.ProductModel;
import com.hexagonal.architecture.app.adapters.repository.model.adapter.ProductModelAdapter;
import com.hexagonal.architecture.app.core.entity.Paged;
import com.hexagonal.architecture.app.core.entity.ProductEntity;
import com.hexagonal.architecture.app.core.repository.ProductRepository;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ProductRepositoryAdapter implements ProductRepository {
    private final ProductModelAdapter modelAdapter;
    public ProductRepositoryAdapter(ProductModelAdapter modelAdapter) {
        this.modelAdapter = modelAdapter;
    }
    @Override
    public Paged<ProductEntity> findAllPaged(Integer page, Integer itemsPerPage) {
        List<ProductModel> modelList;
        long totalItems;

        if (itemsPerPage > 0) {
            Page<ProductModel> pagedModel = findAllPagedBridge(page, itemsPerPage);
            modelList = pagedModel.getContent();
            totalItems = pagedModel.getTotalElements();
        } else {
            modelList = findAllBridge();
            totalItems = modelList.size();
        }

        return new Paged<>(convertToProductList(modelList), totalItems);
    }
    protected abstract List<ProductModel> findAllBridge();
    protected abstract Page<ProductModel> findAllPagedBridge(Integer page, Integer itemsPerPage);
    private List<ProductEntity> convertToProductList(List<ProductModel> items) {
        return items.stream()
                .map(modelAdapter::toEntity)
                .collect(Collectors.toList());
    }
    @Override
    public ProductEntity findById(Long code) {
        ProductModel model = findByIdBridge(code);
        if (model == null) {
            return null;
        }

        return modelAdapter.toEntity(model);
    }
    protected abstract ProductModel findByIdBridge(Long id);
    @Override
    public void save(ProductEntity product) {
        saveBridge(modelAdapter.toModel(product));
    }
    protected abstract void saveBridge(ProductModel productModel);

}
