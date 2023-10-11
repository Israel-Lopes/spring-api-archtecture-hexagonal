package com.hexagonal.architecture.app.adapters.mapper;

public interface OutputMapper<T, E> {
    E fromEntity(T entity);
}