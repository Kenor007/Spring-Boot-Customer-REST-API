package com.example.customer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CustomerResponse {
    private String firstName;
    private String lastName;
    private String productName;

    public CustomerResponse(String firstName, String lastName, String productName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.productName = productName;
    }

    private Integer price;
}