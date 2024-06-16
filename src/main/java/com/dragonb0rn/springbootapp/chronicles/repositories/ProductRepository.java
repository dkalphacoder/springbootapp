package com.dragonb0rn.springbootapp.chronicles.repositories;

import com.dragonb0rn.springbootapp.chronicles.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
