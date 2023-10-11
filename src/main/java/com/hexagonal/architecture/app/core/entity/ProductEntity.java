package com.hexagonal.architecture.app.core.entity;

import com.hexagonal.architecture.app.core.exception.InsufficientProductStockException;

public class ProductEntity {
    private final Long id;
    private final String name;
    private final String description;
    private final Double price;
    private final String image;
    private Integer stock;
    public ProductEntity(Long id, String name, String description, Double price, Integer stock, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Double getPrice() {
        return price;
    }
    public Integer getStock() {
        return stock;
    }
    public String getImage() { return image; }
    public void subtractStock(Integer stockToSubtract) {
        if (stock < stockToSubtract) {
            throw new InsufficientProductStockException(id);
        }
        stock = stock - stockToSubtract;
    }
}
