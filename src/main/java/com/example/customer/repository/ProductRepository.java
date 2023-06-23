package com.example.customer.repository;

import com.example.customer.dto.ProductRequest;
import com.example.customer.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Query(value = "INSERT INTO product (product_name,product_model,product_color,quantity,price) VALUES (:#{#request.productName}," +
            ":#{#request.productModel},:#{#request.color},:#{#request.quantity},:#{#request.price}) ", nativeQuery = true)
    void saveProduct(ProductRequest request);
}