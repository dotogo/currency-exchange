package org.proj3.currencyexchange.mapper;

import org.proj3.currencyexchange.dto.CurrencyDto;
import org.proj3.currencyexchange.entity.CurrencyEntity;

public class CurrencyMapper {
    private static final CurrencyMapper INSTANCE = new CurrencyMapper();

    private CurrencyMapper() {
    }

    public static CurrencyMapper getInstance() {
        return INSTANCE;
    }

    public CurrencyEntity toEntity(CurrencyDto dto) {
        String code = dto.getCode();
        String fullName = dto.getFullName();
        String sign = dto.getSign();
        return new CurrencyEntity(code, fullName, sign);

    }

    public CurrencyDto toDto(CurrencyEntity entity) {
        String code = entity.getCode();
        String fullName = entity.getFullName();
        String sign = entity.getSign();

        CurrencyDto dto = new CurrencyDto();
        dto.setCode(code);
        dto.setFullName(fullName);
        dto.setSign(sign);

        return dto;
    }
}
