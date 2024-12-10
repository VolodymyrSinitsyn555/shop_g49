package ait.cohort49.shop.controller;

import ait.cohort49.shop.model.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return product;
    }

//    @GetMapping
//    public Product getProductById(@RequestParam Long id) {
//        return null;
//    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return List.of();
    }


    // 1. параметр id продукта что хотим обновить 2. параметр - то что мы хотим изменить( новые праметры продукта)
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return product;
    }

    @DeleteMapping("/{id}")
    public Product remove(@PathVariable Long id) {
        return null;
    }

}
