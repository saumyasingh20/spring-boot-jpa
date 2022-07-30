package com.operative.springbootjpa.controller;

import com.operative.springbootjpa.entity.Product;
import com.operative.springbootjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api")

public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/product/list")
    public List<Product> listProducts(){
        return productService.listProducts();
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/product/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") Long id){
        return productService.updateProduct(product,id);
    }

    @GetMapping("/product/find/manufacturer/{manu}")
    public List<Product> getProductsByManufacturer(@PathVariable("manu") String manu){
        return productService.getProductsByManufacturer(manu.toLowerCase());
    }

    @GetMapping("/product/find/name/{name}")
    public List<Product> getProductsByName(@PathVariable("name") String name){
        return productService.getProductsByName(name.toLowerCase());
    }

    @GetMapping("/product/find/price/{price}")
    public List<Product> getProductsByPrice(@PathVariable("price") Double price){
        return productService.getProductsByPrice(price);
    }

    @GetMapping("/product/find/id/{id}")
    public Product getProductByID(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
}
