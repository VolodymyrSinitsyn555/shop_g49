package ait.cohort49.shop.repository;

import ait.cohort49.shop.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    void deleteByIdBetween(Long startId, Long endId);
}
