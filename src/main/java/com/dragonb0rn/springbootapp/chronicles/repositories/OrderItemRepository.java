package com.dragonb0rn.springbootapp.chronicles.repositories;

import com.dragonb0rn.springbootapp.chronicles.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
