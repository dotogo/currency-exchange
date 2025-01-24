package org.proj3.currencyexchange.dao;

import org.proj3.currencyexchange.entity.CurrencyEntity;
import org.proj3.currencyexchange.exception.DaoException;
import org.proj3.currencyexchange.util.DatabaseConfig;

import javax.sql.DataSource;
import java.sql.*;

public class CurrencyDao {
    private static final CurrencyDao INSTANCE = new CurrencyDao();
    private static final DataSource dataSource = DatabaseConfig.getDataSource();

    private static final String SAVE_SQL = """
            INSERT INTO currencies (code, full_name, sign)
            VALUES (?, ?, ?)
            """;

    private CurrencyDao() {
    }

    public CurrencyEntity save(CurrencyEntity currency) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, currency.getCode());
            preparedStatement.setString(2, currency.getFullName());
            preparedStatement.setString(3, currency.getSign());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt("id");
                currency.setId(generatedId);
            }
            return currency;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static CurrencyDao getInstance() {
        return INSTANCE;
    }

//    id, base_currency_id, target_currency_id, rate
}
