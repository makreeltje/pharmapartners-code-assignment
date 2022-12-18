package com.pharmapartners.backend.web.controllers;

import com.pharmapartners.backend.config.LoggingAspect;
import com.pharmapartners.backend.domain.CurrencyService;
import com.pharmapartners.backend.domain.exceptions.CurrencyNotFoundException;
import com.pharmapartners.backend.web.dto.CurrencyDto;
import com.pharmapartners.backend.web.mapper.CurrencyMapper;
import com.pharmapartners.backend.web.model.CurrencyRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/currencies")
@Validated
@Slf4j
public class CurrencyController {

    private final CurrencyService currencyService;
    private final CurrencyMapper currencyMapper;

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    public CurrencyController(CurrencyService currencyService, CurrencyMapper currencyMapper) {
        this.currencyService = currencyService;
        this.currencyMapper = currencyMapper;
    }

    @GetMapping
    public Page<CurrencyDto> getAll(
            @RequestParam(value = "page", required = false, defaultValue = "0") final int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        final var pageRequest = PageRequest.of(page, size);
        final var currencies = currencyService.findAll(pageRequest);

        return currencies.map(currencyMapper::toDto);
    }

    @GetMapping("/{id}")
    public CurrencyDto get(@PathVariable("id") final Long id) throws CurrencyNotFoundException {
        logger.info("Getting currency with id: {}", id);
        final var optionalCurrency = currencyService.findById(id);
        var currency = optionalCurrency.orElseThrow(() -> new CurrencyNotFoundException(id));
        logger.info("Currency with id: {} found", id);
        return currencyMapper.toDto(currency);
    }

    @PostMapping
    public CurrencyDto create(@Valid @RequestBody final CurrencyRequestModel currencyDto) {
        logger.info("Creating currency with name: {}", currencyDto.getName());
        var currency = Optional.of(currencyMapper.toModel(currencyDto));
        final var result = currencyService.create(currency.get());
        logger.info("Currency with name: {} created", currencyDto.getName());
        return currencyMapper.toDto(result);
    }

    @PutMapping("/{id}")
    public CurrencyDto update(@PathVariable final Long id, @Valid @RequestBody final CurrencyRequestModel model) throws CurrencyNotFoundException {
        var currency = currencyService.findById(id);

        if (currency.isPresent()) {
            logger.info("Updating currency with id: {}", id);
            currencyMapper.updateModel(currency.get(), model);
        } else {
            throw new CurrencyNotFoundException(id);
        }
        logger.info("Currency with id: {} updated", id);
        final var result = currencyService.create(currency.get());
        return currencyMapper.toDto(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable final Long id) throws CurrencyNotFoundException {
        var optionalCurrency = currencyService.findById(id);
        var currency = optionalCurrency.orElseThrow(() -> new CurrencyNotFoundException(id));
        logger.info("Deleting currency with id: {}", id);
        currencyService.delete(currency);
        logger.info("Currency with id: {} deleted", id);
        return ResponseEntity.noContent().build();
    }
}
