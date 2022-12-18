package com.pharmapartners.backend.web.mapper;

import com.pharmapartners.backend.data.entity.Currency;
import com.pharmapartners.backend.web.dto.CurrencyDto;
import com.pharmapartners.backend.web.model.CurrencyRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CurrencyMapper {
    @Mapping(target = "name", source = "name")
    Currency toModel(CurrencyRequestModel currencyRequestModel);

    @Mapping(target = "name", source = "name")
    void updateModel(@MappingTarget Currency currency, CurrencyRequestModel currencyRequestModel);

    CurrencyDto toDto(Currency currency);
}
