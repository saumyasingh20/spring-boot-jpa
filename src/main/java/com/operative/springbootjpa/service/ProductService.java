package com.operative.springbootjpa.service;

import com.operative.springbootjpa.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product addProduct(Product product);
    public List<Product> listProducts();
    public void deleteProduct(Long id);
    public Product updateProduct(Product prod,Long id);

    public List<Product> getProductsByManufacturer(String manu);
    public List<Product> getProductsByName(String name);
    public List<Product> getProductsByPrice(Double price);

    public Product getProductById(Long id);

}
