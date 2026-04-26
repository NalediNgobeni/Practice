package za.ac.cput.practice.service;

import za.ac.cput.practice.domain.Customer;
import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    Customer read(String patientId);
    Customer update(Customer customer);
    boolean delete(String patientId);
    List<Customer> getAll();
}