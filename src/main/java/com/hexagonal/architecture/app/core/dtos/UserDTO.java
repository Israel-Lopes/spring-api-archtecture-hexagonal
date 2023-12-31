package com.hexagonal.architecture.app.core.dtos;

public class UserDTO {
    private final Long id;
    private final String name;
    public UserDTO(Long id, String name) {
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
