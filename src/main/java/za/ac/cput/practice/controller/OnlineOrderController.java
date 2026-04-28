package za.ac.cput.practice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.practice.domain.OnlineOrder;
import za.ac.cput.practice.service.OnlineOrderService;

import java.util.List;

@RestController
@RequestMapping("/onlineorder")
public class OnlineOrderController {

    private final OnlineOrder service;


    public OnlineOrderController(OnlineOrderService service) {
        this.service=service;
    }

    // CREATE
    @PostMapping("/create")
    public OnlineOrdercreate(@RequestBody OnlineOrder onlineorder) {

        return service.create(onlineorder);
    }

    // READ
    @GetMapping("/{id}")
    public OnlineOrder read(@PathVariable String id) {

        return service.read(id);
    }
    @GetMapping
    public List<onlineorder> getAll(){
        return service.getAll();
    }


    // UPDATE
    @PutMapping
    public OnlineOrder update(@RequestBody onlineorder onlineorder) {
        return service.update(customer);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);


    }
}