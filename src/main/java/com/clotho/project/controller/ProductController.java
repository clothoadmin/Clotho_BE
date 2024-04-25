package com.clotho.project.controller;

import java.util.Date;
import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clotho.project.DTO.ProductDiscountDTO;
import com.clotho.project.Service.ProductService;
import com.clotho.project.entity.Product;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    private String test = null;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }
    @GetMapping("/listby/{listby}")
    public List<Product> getAllProductsByListby(@PathVariable String listby) {
        return productService.getAllProductsByListby(listby);
    }

    @GetMapping("/size/{size}")
    public List<Product> getAllProductsBySize(@PathVariable String size) {
        return productService.getAllProductsBySize(size);
    }
    
    @GetMapping("/byname/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/listed")
    public List<Product> getAllListedProducts() {
        return productService.getAllListedProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
    	
    	product.setCreatedDate(new Date());
    	product.setModifiedOn(new Date());
        return productService.createProduct(product);
    }
    
    @PostMapping("/calcDiscount")
    public int calculateDiscount(@RequestBody ProductDiscountDTO data) {
    	return discount(data); 
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
    	product.setModifiedOn(new Date());
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
    
    private int discount(ProductDiscountDTO data) {
    	int discount = 0;

        if (data.getAge() < 1) {
            if (data.getCondition().equalsIgnoreCase("best")) {
                discount = data.isPremium() ? 50 : 40;
            } else if (data.getCondition().equalsIgnoreCase("good")) {
                discount = data.isPremium() ? 45 : 38;
            } else if (data.getCondition().equalsIgnoreCase("avg")) {
                discount = data.isPremium() ? 42 : 35;
            }
        } else if (data.getAge() >= 1 && data.getAge() < 3) {
            if (data.getCondition().equalsIgnoreCase("best")) {
                discount = data.isPremium() ? 43 : 36;
            } else if (data.getCondition().equalsIgnoreCase("good")) {
                discount = data.isPremium() ? 39 : 33;
            } else if (data.getCondition().equalsIgnoreCase("avg")) {
                discount = data.isPremium() ? 37 : 30;
            }
        } else if (data.getAge() >= 3) {
            if (data.getCondition().equalsIgnoreCase("best")) {
                discount = data.isPremium() ? 40 : 25;
            } else if (data.getCondition().equalsIgnoreCase("good")) {
                discount = data.isPremium() ? 35 : 23;
            } else if (data.getCondition().equalsIgnoreCase("avg")) {
                discount = data.isPremium() ? 30 : 20;
            }
        }

        return discount;

    }
}