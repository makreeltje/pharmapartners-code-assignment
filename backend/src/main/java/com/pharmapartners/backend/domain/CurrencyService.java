package com.pharmapartners.backend.domain;

import com.pharmapartners.backend.data.entity.Currency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CurrencyService {
    Currency create(Currency currencyToSave);
    Optional<Currency> findById(Long id);
    Page<Currency> findAll(Pageable pageable);
    void delete(Currency currencyToDelete);
}
