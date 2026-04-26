package za.ac.cput.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.practice.domain.OrderItem;
import za.ac.cput.practice.repository.OrderItemRepository;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    @Override
    public OrderItem read(String orderItemId) {
        return repository.findById(orderItemId).orElse(null);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        if (repository.existsById(orderItem.getOrderItemId())) {
            return repository.save(orderItem);
        }
        return null;
    }

    @Override
    public boolean delete(String orderItemId) {
        if (repository.existsById(orderItemId)) {
            repository.deleteById(orderItemId);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderItem> getAll() {
        return repository.findAll();
    }
}