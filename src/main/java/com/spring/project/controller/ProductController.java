package com.spring.project.controller;

import com.spring.project.entity.Product;
import com.spring.project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }
    @GetMapping("/getAllProductByExpirationDate")
    public ResponseEntity<List<Product>> getAllProductByExpirationDateLessThan(){
        return ResponseEntity.ok(productService.getAllProductByExpirationDateGreaterThan());
    }

    @GetMapping("/getAllProductByExpirationDateAndNotNull")
    public ResponseEntity<List<Product>> getAllProductByExpirationDateAndNotNull(){
        return ResponseEntity.ok(productService.getAllProductByExpirationDateAndNotNull());
    }

}
