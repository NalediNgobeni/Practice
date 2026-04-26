package za.ac.cput.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.practice.domain.InStoreOrder;
import za.ac.cput.practice.repository.InStoreOrderRepository;
import java.util.List;

@Service
public class InStoreOrderServiceImpl implements InStoreOrderService {

    private final InStoreOrderRepository repository;

    @Autowired
    public InStoreOrderServiceImpl(InStoreOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public InStoreOrder create(InStoreOrder order) {
        return repository.save(order);
    }

    @Override
    public InStoreOrder read(String orderId) {
        return repository.findById(orderId).orElse(null);
    }

    @Override
    public InStoreOrder update(InStoreOrder order) {
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
    public List<InStoreOrder> getAll() {
        return repository.findAll();
    }
}