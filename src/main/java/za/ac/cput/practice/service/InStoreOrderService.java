package za.ac.cput.practice.service;

import za.ac.cput.practice.domain.InStoreOrder;
import java.util.List;

public interface InStoreOrderService {
    InStoreOrder create(InStoreOrder order);
    InStoreOrder read(String orderId);
    InStoreOrder update(InStoreOrder order);
    boolean delete(String orderId);
    List<InStoreOrder> getAll();
}