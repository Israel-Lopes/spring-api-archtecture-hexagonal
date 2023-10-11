package com.hexagonal.architecture.app.core.repository;

import com.hexagonal.architecture.app.core.dtos.UserDTO;

public interface UserRepository {
    UserDTO findById(Long id);
    void save(UserDTO user);
}
