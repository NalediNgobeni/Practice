package za.ac.cput.practice.service;

import za.ac.cput.practice.domain.Product;
import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product read(String productId);
    Product update(Product product);
    boolean delete(String productId);
    List<Product> getAll();
}
