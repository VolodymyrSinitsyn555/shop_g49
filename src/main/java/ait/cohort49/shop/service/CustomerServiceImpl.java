package ait.cohort49.shop.service;

import ait.cohort49.shop.model.entity.Customer;
import ait.cohort49.shop.model.entity.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{


    @Override
    public void saveCustomer(Customer customer) {

    }

    @Override
    public List<Customer> getAllActiveCustomers() {
        return List.of();
    }

    @Override
    public Customer getActiveCustomerById(Long customerId) {
        return null;
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
