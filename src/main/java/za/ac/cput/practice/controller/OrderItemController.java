package za.ac.cput.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.practice.domain.OrderItem;
import za.ac.cput.practice.service.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderItem> create(@RequestBody OrderItem orderItem) {
        OrderItem created = orderItemService.create(orderItem);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<OrderItem> read(@PathVariable String id) {
        OrderItem orderItem = orderItemService.read(id);
        if (orderItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderItem, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<OrderItem> update(@RequestBody OrderItem orderItem) {
        OrderItem updated = orderItemService.update(orderItem);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        boolean deleted = orderItemService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<OrderItem>> getAll() {
        List<OrderItem> orderItems = orderItemService.getAll();
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }
}