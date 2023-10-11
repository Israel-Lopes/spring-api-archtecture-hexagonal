package com.hexagonal.architecture.app.adapters.repository.model;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "product")
public class ProductModel {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private Integer stock;
    public Long getId() {
        return id;
    }
    public void setId(Long code) {
        this.id = code;
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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}