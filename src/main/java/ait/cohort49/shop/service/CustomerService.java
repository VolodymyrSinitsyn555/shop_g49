package ait.cohort49.shop.service;

import ait.cohort49.shop.model.entity.Customer;
import ait.cohort49.shop.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);

    List<Customer> getAllActiveCustomers();

    Customer getActiveCustomerById(Long customerId);

    Customer updateCustomerById(Long customerId, Customer updatedCustomer);

    Customer deleteCustomerById(Long customerId);

    Customer deleteCustomerByName(String customerName);

    Customer restoreCustomerById(Long customerId);

    int getActiveCustomerCount();

    BigDecimal getCartTotalByCustomerId(Long customerId);

    BigDecimal getAverageProductPriceInCart(Long customerId);

    Product addProductToCart(Long customerId, Long productId);

    void removeProductFromCart(Long customerId, Long productId);

    void clearCart(Long customerId);
}
