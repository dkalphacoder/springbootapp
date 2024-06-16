package com.dragonb0rn.springbootapp.chronicles.controllers;

import com.dragonb0rn.springbootapp.chronicles.dto.OrderDTO;
import com.dragonb0rn.springbootapp.chronicles.dto.OrderItemDTO;
import com.dragonb0rn.springbootapp.chronicles.entities.Order;
import com.dragonb0rn.springbootapp.chronicles.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId)
                .map(order -> {
                    OrderDTO orderDTO = OrderService.convertToOrderDTO(order);
                    return ResponseEntity.ok(orderDTO);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestParam Long userId, @RequestBody List<OrderItemDTO> items) {
        Order order = orderService.placeOrder(userId, items);
        OrderDTO responseDTO = OrderService.convertToOrderDTO(order);
        return ResponseEntity.ok(responseDTO);
    }
}
