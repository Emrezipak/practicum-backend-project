package com.spring.project.repository;

import com.spring.project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    boolean existsById(Long productId);
    List<Product> getAllProductByExpirationDateLessThan(LocalDateTime expirationDate);
    List<Product> getAllProductByExpirationDateIsGreaterThanOrExpirationDateIsNull(LocalDateTime expirationDate);
    //boolean getAllByExpirationDateAfter();
}
