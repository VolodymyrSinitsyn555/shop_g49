package ait.cohort49.shop.repository;

import ait.cohort49.shop.model.dto.ProductDTO;
import ait.cohort49.shop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByActiveTrue();

}