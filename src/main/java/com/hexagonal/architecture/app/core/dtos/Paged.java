package com.hexagonal.architecture.app.core.dtos;

import java.util.List;

public class Paged<T> {

  private final List<T> items;
  private Long totalItems;

  public Paged(List<T> items, Long totalItems) {
    this.items = items;
    this.totalItems = totalItems;
  }

  public List<T> getItems() {
    return items;
  }

  public Long getTotalItems() {
    return totalItems;
  }
}