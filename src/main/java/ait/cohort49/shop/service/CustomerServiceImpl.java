package ait.cohort49.shop.service;

import ait.cohort49.shop.model.entity.Customer;
import ait.cohort49.shop.model.entity.Product;
import ait.cohort49.shop.repository.CustomerRepository;
import ait.cohort49.shop.repository.ProductRepository;
import ait.cohort49.shop.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setActive(true);
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllActiveCustomers() {
        return repository.findAll().stream()
                .filter(Customer::isActive)
                .toList();
    }

    @Override
    public Customer getActiveCustomerById(Long id) {
        Customer customer = repository.findById(id).orElse(null);
        if (customer == null || !customer.isActive()) {
        return null;
        }
        return customer;
    }

    @Override
    public Customer updateCustomerById(Long customerId, Customer updatedCustomer) {
        return null;
    }

    @Override
    public Customer deleteCustomerById(Long customerId) {
        return null;
    }

    @Override
    public Customer deleteCustomerByName(String customerName) {
        return null;
    }

    @Override
    public Customer restoreCustomerById(Long customerId) {
        return null;
    }

    @Override
    public int getActiveCustomerCount() {
        return 0;
    }

    @Override
    public BigDecimal getCartTotalByCustomerId(Long customerId) {
        return null;
    }

    @Override
    public BigDecimal getAverageProductPriceInCart(Long customerId) {
        return null;
    }

    @Override
    public Product addProductToCart(Long customerId, Long productId) {
        return null;
    }

    @Override
    public void removeProductFromCart(Long customerId, Long productId) {

    }

    @Override
    public void clearCart(Long customerId) {

    }
}
