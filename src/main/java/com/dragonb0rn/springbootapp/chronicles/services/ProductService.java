package com.dragonb0rn.springbootapp.chronicles.services;

import com.dragonb0rn.springbootapp.chronicles.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Product product);
}
