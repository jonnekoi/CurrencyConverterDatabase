package controller;

import model.Currency;
import view.ConverterGUI;

public class Controller {
    private Currency currencyModel;
    private ConverterGUI converterView;

    public Controller(Currency currencyModel, ConverterGUI converterView) {
        this.currencyModel = currencyModel;
        this.converterView = converterView;
    }

    public double convertCurrencies() {
        String from = converterView.fromCurrency();
        String to = converterView.toCurrency();
        double amount = converterView.getAmount();
        double result = currencyModel.convert(from, to, amount);
        return result;
    }
    public static void main(String[] args) {
        ConverterGUI.launch(ConverterGUI.class);
    }
}