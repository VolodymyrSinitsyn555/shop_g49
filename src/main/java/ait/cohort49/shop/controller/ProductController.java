package ait.cohort49.shop.controller;

import ait.cohort49.shop.model.entity.Product;
import ait.cohort49.shop.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


// http://localhost:8080/products

// /login - фронт endpoint
// /api/login
// /api/products

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create: POST -> /products
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Получение ресурса
    // GET /products/5
    // GET /products/1565
    // GET /products/55
    @GetMapping("/{productId}")
    public Product getById(@PathVariable("productId") Long id) {
        return productService.getProductById(id);
    }

    // get:  GET /products
    @GetMapping
    public List<Product> getAll() {
        return productService.getAllActiveProducts();
    }

    // Update: PUT -> /products/5
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    // Delete: DELETE -> /products/3
    @DeleteMapping("/{id}")
    public Product remove(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    // Delete: DELETE -> /products/by-title?title=Banana
    @DeleteMapping("/by-title")
    public Product deleteProductByTitle(@RequestParam String title) {
        return productService.deleteProductByTitle(title);
    }

    // PUT -> /products/restore/25
    @PutMapping("/restore/{id}")
    public Product restoreProductById(@PathVariable Long id) {
        return productService.restoreProductById(id);
    }

    @GetMapping("/count")
    public long getProductsCount() {
        return productService.getProductsCount();
    }

    @GetMapping("/total-price")
    public BigDecimal getTotalPrice() {
        return productService.getTotalPrice();
    }

    @GetMapping("/average-price")
    public BigDecimal getAveragePrice() {
        return productService.getAveragePrice();
    }
}
