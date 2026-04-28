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


    public CustomerController(CustomerService service) {
        this.service=service;
    }

    // CREATE
    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {

        return service.create(customer);
    }

    // READ
    @GetMapping("/{id}")
    public Customer read(@PathVariable String id) {

           return service.read(id);
        }
    @GetMapping
    public List<Customer> getAll(){
        return service.getAll();
    }


    // UPDATE
    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
       service.delete(id);


    }
}