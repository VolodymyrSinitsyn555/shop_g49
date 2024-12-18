package ait.cohort49.shop.service.interfaces;

import ait.cohort49.shop.model.dto.CustomerDTO;
import ait.cohort49.shop.model.entity.Customer;
import ait.cohort49.shop.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService  {

    CustomerDTO saveCustomer(CustomerDTO customer);

    List<CustomerDTO> getAllActiveCustomers();

    CustomerDTO getActiveCustomerById(Long customerId);

    CustomerDTO updateCustomerById(Long customerId, CustomerDTO updatedCustomer);

    CustomerDTO deleteCustomerById(Long customerId);

    CustomerDTO deleteCustomerByName(String customerName);

    CustomerDTO restoreCustomerById(Long customerId);

    int getActiveCustomerCount();

    BigDecimal getCartTotalByCustomerId(Long customerId);

    BigDecimal getAverageProductPriceInCart(Long customerId);

    Product addProductToCart(Long customerId, Long productId);

    void removeProductFromCart(Long customerId, Long productId);

    void clearCart(Long customerId);

    void deleteCustomersInRange(Long startId, Long endId);
}
