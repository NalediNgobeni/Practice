package za.ac.cput.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.practice.domain.Customer;
import za.ac.cput.practice.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        Customer created = customerService.create(customer);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // READ
    @GetMapping("/read/{id}")
    public ResponseEntity<Customer> read(@PathVariable String id) {
        Customer customer = customerService.read(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        Customer updated = customerService.update(customer);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        boolean deleted = customerService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // GET ALL
    @GetMapping("/getall")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customers = customerService.getAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}