package za.ac.cput.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.practice.domain.Order;
import za.ac.cput.practice.repository.OrderRepository;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    public Order read(String orderId) {
        return repository.findById(orderId).orElse(null);
    }

    @Override
    public Order update(Order order) {
        if (repository.existsById(order.getOrderId())) {
            return repository.save(order);
        }
        return null;
    }

    @Override
    public boolean delete(String orderId) {
        if (repository.existsById(orderId)) {
            repository.deleteById(orderId);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }
}