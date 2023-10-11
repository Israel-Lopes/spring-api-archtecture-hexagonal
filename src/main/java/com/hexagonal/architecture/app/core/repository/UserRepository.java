package com.hexagonal.architecture.app.core.repository;

import com.hexagonal.architecture.app.core.entity.UserEntity;

public interface UserRepository {
    UserEntity findById(Long id);
    void save(UserEntity user);
}
