package za.ac.cput.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.practice.domain.InStoreOrder;
import za.ac.cput.practice.service.InStoreOrderService;

import java.util.List;

@RestController
@RequestMapping("/instoreorder")
public class InStoreOrderController {

    private final InStoreOrderService inStoreOrderService;

    @Autowired
    public InStoreOrderController(InStoreOrderService inStoreOrderService) {
        this.inStoreOrderService = inStoreOrderService;
    }

    @PostMapping("/create")
    public ResponseEntity<InStoreOrder> create(@RequestBody InStoreOrder order) {
        InStoreOrder created = inStoreOrderService.create(order);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<InStoreOrder> read(@PathVariable String id) {
        InStoreOrder order = inStoreOrderService.read(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<InStoreOrder> update(@RequestBody InStoreOrder order) {
        InStoreOrder updated = inStoreOrderService.update(order);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        boolean deleted = inStoreOrderService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<InStoreOrder>> getAll() {
        List<InStoreOrder> orders = inStoreOrderService.getAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}