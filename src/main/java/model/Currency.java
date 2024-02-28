package model;

import java.util.HashMap;

public class Currency {
    private HashMap<String, Double> currencies;

    public Currency() {
        currencies = new HashMap<>();
        currencies.put("EUR", 1.0);
        currencies.put("USD", 1.0815729);
        currencies.put("GBP", 0.85517829);
        currencies.put("SEK", 11.199002);
        currencies.put("JPY", 162.97802);
        currencies.put("CAD", 1.4689859);
    }

    public double convert(String from, String target, double amount) {
        return amount * currencies.get(target) / currencies.get(from);
    }
}