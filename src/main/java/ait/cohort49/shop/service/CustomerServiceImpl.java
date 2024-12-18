package ait.cohort49.shop.service;

import ait.cohort49.shop.model.dto.CustomerDTO;
import ait.cohort49.shop.model.entity.Cart;
import ait.cohort49.shop.model.entity.Customer;
import ait.cohort49.shop.model.entity.Product;
import ait.cohort49.shop.repository.CustomerRepository;
import ait.cohort49.shop.service.interfaces.CustomerService;
import ait.cohort49.shop.service.mapping.CustomerMappingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMappingService mappingService;

    public CustomerServiceImpl(CustomerRepository repository, CustomerMappingService mappingService) {
        this.repository = repository;
        this.mappingService = mappingService;
    }

    @Override
    @Transactional
    public CustomerDTO saveCustomer(CustomerDTO customerDto) {
        Customer customer = mappingService.mapDtoToEntity(customerDto);
        customer.setActive(true);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        return mappingService.mapEntityToDto(repository.save(customer));

    }

    @Override
    public List<CustomerDTO> getAllActiveCustomers() {
        return repository.findAll().stream()
                .filter(Customer::isActive)
                .map(mappingService::mapEntityToDto)
                .toList();
    }

    @Override
    public CustomerDTO getActiveCustomerById(Long id) {
        Customer customer = repository.findById(id).orElse(null);
        if (customer == null || !customer.isActive()) {
            return null;
        }
        return mappingService.mapEntityToDto(customer);
    }

    @Override
    public CustomerDTO updateCustomerById(Long customerId, CustomerDTO updatedCustomer) {
        return null;
    }

    @Override
    public CustomerDTO deleteCustomerById(Long customerId) {
        repository.deleteById(customerId);
        return null;
    }

    @Override
    public CustomerDTO deleteCustomerByName(String customerName) {
        return null;
    }

    @Override
    public CustomerDTO restoreCustomerById(Long customerId) {
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

    @Transactional
    public void deleteCustomersInRange(Long startId, Long endId) {
        repository.deleteByIdBetween(startId, endId);
    }
}
