package com.operative.springbootjpa.service;

import com.operative.springbootjpa.entity.Product;
import com.operative.springbootjpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {

         product.setName(product.getName().toLowerCase());
         product.setManu(product.getManu().toLowerCase());

         return productRepository.save(product);
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


    public Product updateProduct(Product prod,Long id){

       Product p= productRepository.findById(id).get();
       p.setName(prod.getName());
       p.setDesc(prod.getDesc());
       p.setManu(prod.getManu());
       p.setPrice(prod.getPrice());
       return productRepository.save(p);

    }

    @Override
    public List<Product> getProductsByManufacturer(String manu) {
         return productRepository.findByManu(manu);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByPrice(Double price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }
}
