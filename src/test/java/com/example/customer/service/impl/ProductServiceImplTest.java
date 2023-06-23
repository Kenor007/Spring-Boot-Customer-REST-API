package com.example.customer.service.impl;

import com.example.customer.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

    @Test
    void getAllProductsNotExist() {
        assertThrows(NullPointerException.class, () -> productService.getAllProducts());
    }
}