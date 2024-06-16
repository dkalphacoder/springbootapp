package com.dragonb0rn.springbootapp.chronicles.services;

import com.dragonb0rn.springbootapp.chronicles.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User updateUser(Long id, User user);

    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void delete(User user);

    Optional<User> findByEmail(String email);

}