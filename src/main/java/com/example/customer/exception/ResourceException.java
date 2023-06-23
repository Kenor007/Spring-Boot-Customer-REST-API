package com.example.customer.exception;

import org.springframework.http.HttpStatus;

public record ResourceException(String message, Throwable throwable, HttpStatus httpStatus) {
}