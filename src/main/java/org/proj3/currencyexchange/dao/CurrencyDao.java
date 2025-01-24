package org.proj3.currencyexchange.dao;

public class CurrencyDao {
    private static final CurrencyDao INSTANCE = new CurrencyDao();

    private CurrencyDao() {
    }

    public static CurrencyDao getInstance() {
        return INSTANCE;
    }
}
