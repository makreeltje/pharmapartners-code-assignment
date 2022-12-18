package com.pharmapartners.backend.domain.impl;

import com.pharmapartners.backend.data.entity.Currency;
import com.pharmapartners.backend.data.repository.CurrencyRepository;
import com.pharmapartners.backend.domain.CurrencyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }
    @Override
    public Currency create(Currency currencyToSave) {
        return currencyRepository.save(currencyToSave);
    }

    @Override
    public Optional<Currency> findById(Long id) {
        return currencyRepository.findById(id);
    }

    @Override
    public Page<Currency> findAll(Pageable pageable) {
        return currencyRepository.findAll(pageable);
    }

    @Override
    public void delete(Currency currencyToDelete) {
        currencyRepository.delete(currencyToDelete);
    }
}
