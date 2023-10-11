package com.hexagonal.architecture.app.adapters.mapper.product;

import com.hexagonal.architecture.app.adapters.mapper.OutputMapper;
import com.hexagonal.architecture.app.core.entity.ProductEntity;

public class ProductOutputData implements OutputMapper<ProductEntity, ProductOutputData> {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String image;
    @Override
    public ProductOutputData fromEntity(ProductEntity entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        image = entity.getImage();
        stock = entity.getStock();
        return this;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
