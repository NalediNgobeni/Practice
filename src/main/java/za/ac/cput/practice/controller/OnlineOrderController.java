package za.ac.cput.practice.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.practice.domain.OnlineOrder;
import za.ac.cput.practice.service.OnlineOrderService;

import java.util.List;

@RestController
@RequestMapping("/onlineorder")
public class OnlineOrderController {

    private final OnlineOrderService service;

    public OnlineOrderController(OnlineOrderService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public OnlineOrder create(@RequestBody OnlineOrder onlineOrder) {
        return service.create(onlineOrder);
    }


    @GetMapping("/{id}")
    public OnlineOrder read(@PathVariable String id) {
        return service.read(id);
    }


    @GetMapping
    public List<OnlineOrder> getAll() {
        return service.getAll();
    }


    @PutMapping("/update")
    public OnlineOrder update(@RequestBody OnlineOrder onlineOrder) {
        return service.update(onlineOrder);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}