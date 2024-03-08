package controller;

import dao.CurrencyDao;
import datasource.dbconn;
import view.ConverterGUI;
import java.sql.SQLException;

public class Controller {
    private CurrencyDao currencyDao;
    private ConverterGUI converterView;

    public Controller(dbconn db, ConverterGUI converterView) {
        this.currencyDao = new CurrencyDao(db);
        this.converterView = converterView;
    }

    public double convertCurrencies() {
        String from = converterView.fromCurrency();
        String to = converterView.toCurrency();
        double amount = converterView.getAmount();
        double result = 0;

        try{
            double fromRate = currencyDao.getExchangeRage(from);
            double toRate = currencyDao.getExchangeRage(to);
            result = amount * toRate / fromRate;
        }catch (SQLException e){
            System.out.println("error: " + e.getMessage());
        }
        return result;
    }
    public static void main(String[] args) {
        ConverterGUI.launch(ConverterGUI.class);
    }
}