package com.spring.project.service;

import com.spring.project.entity.Product;
import com.spring.project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductByProductId(Long productId){
        Optional<Product> product = productRepository.findById(productId);
        return product;
    }
    public List<Product> getAllProductByExpirationDateGreaterThan(){
        return productRepository.getAllProductByExpirationDateLessThan(getDateNow());
    }
    public List<Product> getAllProductByExpirationDateAndNotNull(){
        return productRepository.getAllProductByExpirationDateIsGreaterThanOrExpirationDateIsNull(getDateNow());
    }
    private LocalDateTime getDateNow(){
        LocalDateTime now = LocalDateTime.now();
        return now;
    }
}
