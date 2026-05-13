package za.ac.cput.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.practice.domain.Order;
import za.ac.cput.practice.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;


    public OrderController(OrderService service) {
        this.service=service;
    }

    // CREATE
    @PostMapping("/create")
    public Order create(@RequestBody Order order) {

        return service.create(order);
    }


    @GetMapping("/{id}")
    public Order read(@PathVariable String id) {

        return service.read(id);
    }
    @GetMapping
    public List<Order> getAll(){
        return service.getAll();
    }



    @PutMapping
    public Order update(@RequestBody Order order) {
        return service.update(order);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);


    }
}