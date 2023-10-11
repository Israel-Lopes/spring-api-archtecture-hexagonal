package com.hexagonal.architecture.app.adapters.repository.model.adapter;

import com.hexagonal.architecture.app.adapters.repository.ModelAdapter;
import com.hexagonal.architecture.app.adapters.repository.model.ProductEntity;
import com.hexagonal.architecture.app.core.dtos.ProductDTO;

public class ProductModelAdapter implements ModelAdapter<ProductDTO, ProductEntity> {
    @Override
    public ProductEntity toModel(ProductDTO entity) {
        ProductEntity model = new ProductEntity();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setImage(entity.getImage());
        model.setPrice(entity.getPrice());
        model.setStock(entity.getStock());
        return model;
    }
    @Override
    public ProductDTO toEntity(ProductEntity model) {
        return new ProductDTO(model.getId(), model.getName(), model.getDescription(), model.getPrice(),
                model.getStock(), model.getImage());
    }
}
