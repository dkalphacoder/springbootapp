package com.dragonb0rn.springbootapp.chronicles.services;

import com.dragonb0rn.springbootapp.chronicles.dto.OrderDTO;
import com.dragonb0rn.springbootapp.chronicles.dto.OrderItemDTO;
import com.dragonb0rn.springbootapp.chronicles.entities.Order;
import com.dragonb0rn.springbootapp.chronicles.entities.OrderItem;
import com.dragonb0rn.springbootapp.chronicles.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Long userId, List<OrderItemDTO> itemDTOs) {
        Order order = new Order();
        order.setUserId(userId);

        List<OrderItem> items = itemDTOs.stream().map(dto -> {
            OrderItem item = new OrderItem();
            item.setProductId(dto.getProductId());
            item.setQuantity(dto.getQuantity());
            item.setOrder(order);
            return item;
        }).collect(Collectors.toList());


        order.setItems(items);
        items.forEach(item -> item.setOrder(order));
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public static OrderDTO convertToOrderDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setOrderDate(order.getOrderDate());

        List<OrderItemDTO> itemDTOs = new ArrayList<>();
        for(OrderItem oi: order.getItems()) {
            itemDTOs.add(convertToOrderItemDTO(oi));
        }

        dto.setItems(itemDTOs);

        return dto;
    }

    private static OrderItemDTO convertToOrderItemDTO(OrderItem item) {
        OrderItemDTO itemDTO = new OrderItemDTO();
        itemDTO.setProductId(item.getProductId());
        itemDTO.setQuantity(item.getQuantity());
        return itemDTO;
    }

}
