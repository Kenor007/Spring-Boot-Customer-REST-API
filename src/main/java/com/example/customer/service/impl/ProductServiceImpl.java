package com.example.customer.service.impl;

import com.example.customer.dto.ProductRequest;
import com.example.customer.exception.ResourceNotFoundException;
import com.example.customer.model.Product;
import com.example.customer.repository.ProductRepository;
import com.example.customer.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        if (productRepository.findAll().isEmpty())
            throw new ResourceNotFoundException("Requested products do not exist");
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        if (productRepository.findById(id).isEmpty())
            throw new ResourceNotFoundException("Requested product does not exist");
        return productRepository.findById(id).get();
    }

    public ResponseEntity<?> saveProduct(ProductRequest productRequest) {
        productRepository.saveProduct(productRequest);
        return ResponseEntity.ok().body("Product added");
    }

    @Override
    public Product updateProduct(int id, ProductRequest productRequest) {
        return productRepository.findById(id).map(product -> {
            product.setProductName(productRequest.getProductName());
            product.setProductModel(productRequest.getProductModel());
            product.setColor(productRequest.getColor());
            product.setQuantity(productRequest.getQuantity());
            product.setPrice(productRequest.getPrice());
            return productRepository.save(product);
        }).orElseThrow(() -> new ResourceNotFoundException("Product " + id + " does not found"));
    }

    @Override
    public ResponseEntity<?> deleteProductById(int id) {
        return productRepository.findById(id).map(product -> {
            productRepository.delete(product);
            return ResponseEntity.ok().body("Product " + id + " deleted");
        }).orElseThrow(() -> new ResourceNotFoundException("Product " + id + " does not found"));
    }
}