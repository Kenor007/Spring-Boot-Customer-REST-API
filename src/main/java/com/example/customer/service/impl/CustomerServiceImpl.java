package com.example.customer.service.impl;

import com.example.customer.dto.CustomerRequest;
import com.example.customer.dto.CustomerResponse;
import com.example.customer.exception.ResourceNotFoundException;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        if (customerRepository.findAll().isEmpty())
            throw new ResourceNotFoundException("Requested customers do not exist");
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        if (customerRepository.findById(id).isEmpty())
            throw new ResourceNotFoundException("Requested customer does not exist");
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(int id, CustomerRequest customerRequest) {
        return customerRepository.findById(id).map(customer -> {
            customer.setFirstName(customerRequest.getCustomer().getFirstName());
            customer.setLastName(customerRequest.getCustomer().getLastName());
            customer.setEmail(customerRequest.getCustomer().getEmail());
            customer.setAge(customerRequest.getCustomer().getAge());
            customer.setGender(customerRequest.getCustomer().getGender());
            customer.setProducts(customerRequest.getCustomer().getProducts());
            return customerRepository.save(customer);
        }).orElseThrow(() -> new ResourceNotFoundException("Customer " + id + " does not found"));
    }

    @Override
    public ResponseEntity<?> deleteCustomerById(int id) {
        return customerRepository.findById(id).map(customer -> {
            customerRepository.delete(customer);
            return ResponseEntity.ok().body("Customer " + id + " deleted");
        }).orElseThrow(() -> new ResourceNotFoundException("Customer " + id + " does not found"));
    }

    @Override
    public List<CustomerResponse> getJoinInformation() {
        return customerRepository.getJoinInformation();
    }
}