package com.hexagonal.architecture.app.core.entity;

public class UserEntity {
    private final Long id;
    private final String name;
    public UserEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
