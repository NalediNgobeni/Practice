package za.ac.cput.practice.service;

import za.ac.cput.practice.domain.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem create(OrderItem orderItem);
    OrderItem read(String orderItemId);
    OrderItem update(OrderItem orderItem);
    boolean delete(String orderItemId);
    List<OrderItem> getAll();
}