package org.proj3.currencyexchange.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CurrencyRequestDto {
    private String code;
    private String fullName;
    private String sign;
}
