package ait.cohort49.shop.controller;

import ait.cohort49.shop.model.dto.CustomerDTO;
import ait.cohort49.shop.model.entity.Customer;
import ait.cohort49.shop.model.entity.Product;
import ait.cohort49.shop.service.interfaces.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDto) {
        return customerService.saveCustomer(customerDto);
    }

    @GetMapping("/active")
    public List<CustomerDTO> getAllActiveCustomers() {
        return customerService.getAllActiveCustomers();
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getActiveCustomerById(@PathVariable Long customerId) {
        return customerService.getActiveCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    public CustomerDTO updateCustomerById(@PathVariable Long customerId, @RequestBody CustomerDTO updatedCustomerDto) {
        return customerService.updateCustomerById(customerId, updatedCustomerDto);
    }

    @DeleteMapping("/{customerId}")
    public CustomerDTO deleteCustomerById(@PathVariable Long customerId) {
        return customerService.deleteCustomerById(customerId);
    }

    @DeleteMapping("/name/{customerName}")
    public CustomerDTO deleteCustomerByName(@PathVariable String customerName) {
        return customerService.deleteCustomerByName(customerName);
    }

    @PatchMapping("/restore/{customerId}")
    public CustomerDTO restoreCustomerById(@PathVariable Long customerId) {
        return customerService.restoreCustomerById(customerId);
    }

    @GetMapping("/count")
    public int getActiveCustomerCount() {
        return customerService.getActiveCustomerCount();
    }

    @GetMapping("/{customerId}/cart/total")
    public BigDecimal getCartTotalByCustomerId(@PathVariable Long customerId) {
        return customerService.getCartTotalByCustomerId(customerId);
    }

    @GetMapping("/{customerId}/cart/average")
    public BigDecimal getAverageProductPriceInCart(@PathVariable Long customerId) {
        return customerService.getAverageProductPriceInCart(customerId);
    }

    @PostMapping("/{customerId}/cart/{productId}")
    public Product addProductToCart(@PathVariable Long customerId, @PathVariable Long productId) {
        return customerService.addProductToCart(customerId, productId);
    }

    @DeleteMapping("/{customerId}/cart/{productId}")
    public void removeProductFromCart(@PathVariable Long customerId, @PathVariable Long productId) {
        customerService.removeProductFromCart(customerId, productId);
    }

    @DeleteMapping("/{customerId}/cart/clear")
    public void clearCart(@PathVariable Long customerId) {
        customerService.clearCart(customerId);
    }

    @DeleteMapping("/delete-range")
    public ResponseEntity<String> deleteCustomersInRange(
            @RequestParam Long startId,
            @RequestParam Long endId) {
        customerService.deleteCustomersInRange(startId, endId);
        return ResponseEntity.ok("Customers deleted successfully from ID " + startId + " to " + endId);
    }
}
