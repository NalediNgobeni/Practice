package za.ac.cput.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.practice.domain.OnlineOrder;
import za.ac.cput.practice.repository.OnlineOrderRepository;
import java.util.List;

@Service
public class OnlineOrderServiceImpl implements OnlineOrderService {

    private final OnlineOrderRepository repository;

    @Autowired
    public OnlineOrderServiceImpl(OnlineOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OnlineOrder create(OnlineOrder order) {
        return repository.save(order);
    }

    @Override
    public OnlineOrder read(String orderId) {
        return repository.findById(orderId).orElse(null);
    }

    @Override
    public OnlineOrder update(OnlineOrder order) {
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
    public List<OnlineOrder> getAll() {
        return repository.findAll();
    }
}