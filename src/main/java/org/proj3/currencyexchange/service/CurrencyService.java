package org.proj3.currencyexchange.service;

import org.proj3.currencyexchange.dao.CurrencyDao;
import org.proj3.currencyexchange.dto.CurrencyDto;
import org.proj3.currencyexchange.entity.CurrencyEntity;
import org.proj3.currencyexchange.mapper.CurrencyMapper;

public class CurrencyService {
    private static final CurrencyService currencyService = new CurrencyService();
    private static final CurrencyDao currencyDao = CurrencyDao.getInstance();

    private CurrencyService() {
    }

    public CurrencyEntity save(CurrencyDto currencyDto) {
        CurrencyEntity entity = CurrencyMapper.getInstance().toEntity(currencyDto);
        return currencyDao.save(entity);
    }

    public static CurrencyService getInstance() {
        return currencyService;
    }


}
