package com.pharmapartners.backend.data.repository;

import com.pharmapartners.backend.data.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long>, PagingAndSortingRepository<Currency, Long> {

}
