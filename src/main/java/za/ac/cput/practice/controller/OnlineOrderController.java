package za.ac.cput.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.practice.domain.OnlineOrder;
import za.ac.cput.practice.service.OnlineOrderService;

import java.util.List;

@RestController
@RequestMapping("/onlineorder")
public class OnlineOrderController {

    private final OnlineOrderService onlineOrderService;

    @Autowired
    public OnlineOrderController(OnlineOrderService onlineOrderService) {
        this.onlineOrderService = onlineOrderService;
    }

    @PostMapping("/create")
    public ResponseEntity<OnlineOrder> create(@RequestBody OnlineOrder order) {
        OnlineOrder created = onlineOrderService.create(order);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<OnlineOrder> read(@PathVariable String id) {
        OnlineOrder order = onlineOrderService.read(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<OnlineOrder> update(@RequestBody OnlineOrder order) {
        OnlineOrder updated = onlineOrderService.update(order);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        boolean deleted = onlineOrderService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<OnlineOrder>> getAll() {
        List<OnlineOrder> orders = onlineOrderService.getAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}