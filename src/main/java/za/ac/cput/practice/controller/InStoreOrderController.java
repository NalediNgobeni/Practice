package za.ac.cput.practice.controller;


import org.springframework.web.bind.annotation.*;
import za.ac.cput.practice.domain.InStoreOrder;
import za.ac.cput.practice.service.InStoreOrderService;

import java.util.List;

@RestController
@RequestMapping("/instoreorder")
public class InStoreOrderController {

    private final InStoreOrderService service;


    public InStoreOrderController(InStoreOrderService service) {
        this.service=service;
    }


    @PostMapping("/create")
    public InStoreOrder create(@RequestBody InStoreOrder instoreorder) {

        return service.create(instoreorder);
    }


    @GetMapping("/{id}")
    public InStoreOrder read(@PathVariable String id) {

        return service.read(id);
    }
    @GetMapping
    public List<InStoreOrder> getAll(){

        return service.getAll();
    }



    @PutMapping
    public InStoreOrder update(@RequestBody InStoreOrder instoreorder) {
        return service.update(instoreorder);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);


    }
}