package za.ac.cput.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.practice.domain.Customer;
import za.ac.cput.practice.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer read(String patientId) {
        return repository.findById(patientId).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if (repository.existsById(customer.getPatientId())) {
            return repository.save(customer);
        }
        return null;
    }

    @Override
    public boolean delete(String patientId) {
        if (repository.existsById(patientId)) {
            repository.deleteById(patientId);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }
}