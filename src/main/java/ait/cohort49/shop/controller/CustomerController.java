package ait.cohort49.shop.controller;

import ait.cohort49.shop.model.entity.Customer;
import ait.cohort49.shop.model.entity.Product;
import ait.cohort49.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @GetMapping("/active")
    public List<Customer> getAllActiveCustomers() {
        return customerService.getAllActiveCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getActiveCustomerById(@PathVariable Long customerId) {
        return customerService.getActiveCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomerById(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomerById(customerId, updatedCustomer);
    }

    @DeleteMapping("/{customerId}")
    public Customer deleteCustomerById(@PathVariable Long customerId) {
        return customerService.deleteCustomerById(customerId);
    }

    @DeleteMapping("/name/{customerName}")
    public Customer deleteCustomerByName(@PathVariable String customerName) {
        return customerService.deleteCustomerByName(customerName);
    }

    @PatchMapping("/restore/{customerId}")
    public Customer restoreCustomerById(@PathVariable Long customerId) {
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
}
