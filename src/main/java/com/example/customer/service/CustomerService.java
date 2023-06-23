package com.example.customer.service;

import com.example.customer.dto.CustomerRequest;
import com.example.customer.dto.CustomerResponse;
import com.example.customer.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(int id, CustomerRequest customerRequest);

    ResponseEntity<?> deleteCustomerById(int id);

    List<CustomerResponse> getJoinInformation();
}