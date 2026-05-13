package za.ac.cput.practice.controller;


import org.springframework.web.bind.annotation.*;
import za.ac.cput.practice.domain.Customer;
import za.ac.cput.practice.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;


    public CustomerController(CustomerService service) {

        this.service=service;
    }


    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {

        return service.create(customer);
    }


    @GetMapping("/{id}")
    public Customer read(@PathVariable String id) {

           return service.read(id);
        }
    @GetMapping
    public List<Customer> getAll(){
        return service.getAll();
    }



    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
       service.delete(id);


    }
}