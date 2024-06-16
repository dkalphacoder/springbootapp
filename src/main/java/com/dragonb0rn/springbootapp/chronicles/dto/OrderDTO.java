package com.dragonb0rn.springbootapp.chronicles.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private Long id;
    private Long userId;
    private Date orderDate;
    private List<OrderItemDTO> items;

    public OrderDTO() {
    }

    public OrderDTO(Long id, Long userId, Date orderDate, List<OrderItemDTO> items) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
