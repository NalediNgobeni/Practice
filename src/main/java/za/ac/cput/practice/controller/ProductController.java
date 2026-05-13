package za.ac.cput.practice.controller;


import org.springframework.web.bind.annotation.*;
import za.ac.cput.practice.domain.Product;
import za.ac.cput.practice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;


    public ProductController(ProductService service) {
        this.service=service;
    }


    @PostMapping("/create")
    public Product create(@RequestBody Product product) {

        return service.create(product);
    }


    @GetMapping("/{id}")
    public Product read(@PathVariable String id) {

        return service.read(id);
    }
    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }



    @PutMapping
    public Product update(@RequestBody Product product) {
        return service.update(product);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);


    }
}