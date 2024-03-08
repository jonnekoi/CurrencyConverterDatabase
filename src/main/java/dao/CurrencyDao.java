package dao;

import datasource.dbconn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDao {
    private dbconn db;

    public CurrencyDao(dbconn db){
        this.db = db;
    }

    public double getExchangeRage(String Currency) throws SQLException{
        String query = "SELECT conversion_rate FROM CURRENCIES WHERE abbreviation = ?";
        Connection connection = db.getConn();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, Currency);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            return resultSet.getDouble("conversion_rate");
        }else {
            throw new SQLException("Currency not found!");
        }
    }
}
