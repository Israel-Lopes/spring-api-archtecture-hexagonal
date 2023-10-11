package com.hexagonal.architecture.app.adapters.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_product")
public class ProductEntity {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private Integer stock;
}