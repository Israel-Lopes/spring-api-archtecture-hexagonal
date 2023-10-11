package com.hexagonal.architecture.app.adapters.repository.model.adapter;

import com.hexagonal.architecture.app.adapters.repository.ModelAdapter;
import com.hexagonal.architecture.app.adapters.repository.model.ProductModel;
import com.hexagonal.architecture.app.core.entity.ProductEntity;

public class ProductModelAdapter implements ModelAdapter<ProductEntity, ProductModel> {
    @Override
    public ProductModel toModel(ProductEntity entity) {
        ProductModel model = new ProductModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setImage(entity.getImage());
        model.setPrice(entity.getPrice());
        model.setStock(entity.getStock());
        return model;
    }
    @Override
    public ProductEntity toEntity(ProductModel model) {
        return new ProductEntity(model.getId(), model.getName(), model.getDescription(), model.getPrice(),
                model.getStock(), model.getImage());
    }
}
