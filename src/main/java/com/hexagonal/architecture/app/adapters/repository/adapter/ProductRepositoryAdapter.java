package com.hexagonal.architecture.app.adapters.repository.adapter;

import com.hexagonal.architecture.app.adapters.repository.model.ProductEntity;
import com.hexagonal.architecture.app.adapters.repository.model.adapter.ProductModelAdapter;
import com.hexagonal.architecture.app.core.dtos.Paged;
import com.hexagonal.architecture.app.core.dtos.ProductDTO;
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
    public Paged<ProductDTO> findAllPaged(Integer page, Integer itemsPerPage) {
        List<ProductEntity> modelList;
        long totalItems;

        if (itemsPerPage > 0) {
            Page<ProductEntity> pagedModel = findAllPagedBridge(page, itemsPerPage);
            modelList = pagedModel.getContent();
            totalItems = pagedModel.getTotalElements();
        } else {
            modelList = findAllBridge();
            totalItems = modelList.size();
        }

        return new Paged<>(convertToProductList(modelList), totalItems);
    }
    protected abstract List<ProductEntity> findAllBridge();
    protected abstract Page<ProductEntity> findAllPagedBridge(Integer page, Integer itemsPerPage);
    private List<ProductDTO> convertToProductList(List<ProductEntity> items) {
        return items.stream()
                .map(modelAdapter::toEntity)
                .collect(Collectors.toList());
    }
    @Override
    public ProductDTO findById(Long code) {
        ProductEntity model = findByIdBridge(code);
        if (model == null) {
            return null;
        }

        return modelAdapter.toEntity(model);
    }
    protected abstract ProductEntity findByIdBridge(Long id);
    @Override
    public void save(ProductDTO product) {
        saveBridge(modelAdapter.toModel(product));
    }
    protected abstract void saveBridge(ProductEntity entity);

}
