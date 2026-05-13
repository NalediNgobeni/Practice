package za.ac.cput.practice.controller;


import org.springframework.web.bind.annotation.*;
import za.ac.cput.practice.domain.OrderItem;
import za.ac.cput.practice.service.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

    private final OrderItemService service;


    public OrderItemController(OrderItemService service) {
        this.service=service;
    }


    @PostMapping("/create")
    public OrderItem create(@RequestBody OrderItem orderItem) {

        return service.create(orderItem);
    }


    @GetMapping("/{id}")
    public OrderItem read(@PathVariable String id) {

        return service.read(id);
    }
    @GetMapping
    public List<OrderItem> getAll(){
        return service.getAll();
    }



    @PutMapping
    public OrderItem update(@RequestBody OrderItem orderItem) {
        return service.update(orderItem);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);


    }
}