package com.pharmapartners.backend.domain.exceptions;

public class CurrencyNotFoundException extends Exception {
    public CurrencyNotFoundException(Long id) {
        super("Currency with id " + id + " not found");
    }
}
