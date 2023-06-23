package com.example.customer.repository;

import com.example.customer.dto.CustomerResponse;
import com.example.customer.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT new com.example.customer.dto.CustomerResponse( c.firstName,c.lastName,p.productName) FROM Customer c JOIN c.products p")
    List<CustomerResponse> getJoinInformation();
}