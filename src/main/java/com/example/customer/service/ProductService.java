package com.example.customer.service;

import com.example.customer.dto.ProductRequest;
import com.example.customer.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);

    ResponseEntity<?> saveProduct(ProductRequest productRequest);

    Product updateProduct(int id, ProductRequest productRequest);

    ResponseEntity<?> deleteProductById(int id);
}