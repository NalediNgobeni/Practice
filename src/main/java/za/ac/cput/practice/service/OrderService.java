package za.ac.cput.practice.service;
import za.ac.cput.practice.domain.Order;
import java.util.List;

public interface OrderService {
    Order create(Order order);
    Order read(String orderId);
    Order update(Order order);
    boolean delete(String orderId);
    List<Order> getAll();
}