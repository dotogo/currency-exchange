package org.proj3.currencyexchange.service;

import org.proj3.currencyexchange.dao.CurrencyDao;
import org.proj3.currencyexchange.dto.CurrencyDto;
import org.proj3.currencyexchange.entity.CurrencyEntity;
import org.proj3.currencyexchange.mapper.CurrencyMapper;

import java.util.ArrayList;
import java.util.List;

public class CurrencyService {
    private static final CurrencyService currencyService = new CurrencyService();
    private static final CurrencyDao currencyDao = CurrencyDao.getInstance();

    private CurrencyService() {
    }

    public List<CurrencyDto> getCurrencies() {
        List<CurrencyEntity> entities = currencyDao.getCurrencies();
//        List<CurrencyDto> dtos = new ArrayList<CurrencyDto>();
        CurrencyMapper mapper = CurrencyMapper.getInstance();
        return entities.stream()
                .map(mapper::toDto)
                .toList();

//        for (CurrencyEntity entity : entities) {
//            CurrencyMapper mapper = CurrencyMapper.getInstance();
//            CurrencyDto dto = mapper.toDto(entity);
//            dtos.add(dto);
//        }

    }

    public CurrencyEntity save(CurrencyDto currencyDto) {
        CurrencyEntity entity = CurrencyMapper.getInstance().toEntity(currencyDto);
        return currencyDao.save(entity);
    }

    public static CurrencyService getInstance() {
        return currencyService;
    }


}
