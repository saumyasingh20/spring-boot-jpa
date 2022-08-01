package com.operative.springbootjpa.repository;

import com.operative.springbootjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product>findByNameContaining(String name);
    List<Product> findByManu(String manu);
    List<Product> findByPrice(Double price);

}

