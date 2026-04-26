package za.ac.cput.practice.service;

import za.ac.cput.practice.domain.OnlineOrder;
import java.util.List;

public interface OnlineOrderService {
    OnlineOrder create(OnlineOrder order);
    OnlineOrder read(String orderId);
    OnlineOrder update(OnlineOrder order);
    boolean delete(String orderId);
    List<OnlineOrder> getAll();
}
