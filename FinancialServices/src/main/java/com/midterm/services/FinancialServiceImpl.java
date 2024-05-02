// Implementation of SOAP services

package com.midterm.services;

import javax.jws.WebService;
import java.util.Map;
import java.util.HashMap;

@WebService(endpointInterface = "com.midterm.services.FinancialServices")
public class FinancialServiceImpl implements FinancialServices {

    private static final Map<String, Map<String, Double>> exchangeRates = new HashMap<>();

    static {
        Map<String, Double> usdRates = new HashMap<>();
        usdRates.put("EUR", 0.85);
        usdRates.put("GBP", 0.75);
        usdRates.put("TND", 3.25);
        usdRates.put("JPY", 110.25);
        usdRates.put("CAD", 1.25);
        usdRates.put("AUD", 1.35);
        usdRates.put("CHF", 0.91);
        usdRates.put("CNY", 6.45);
        usdRates.put("SEK", 8.76);
        usdRates.put("NZD", 1.42);
        usdRates.put("SGD", 1.35);
        usdRates.put("INR", 74.57);
        exchangeRates.put("USD", usdRates);

        // Define rates for EUR to other currencies
        Map<String, Double> eurRates = new HashMap<>();
        eurRates.put("USD", 1.18);
        eurRates.put("GBP", 0.88);
        eurRates.put("TND", 3.82);
        eurRates.put("JPY", 129.53);
        eurRates.put("CAD", 1.47);
        eurRates.put("AUD", 1.59);
        eurRates.put("CHF", 1.07);
        eurRates.put("CNY", 7.59);
        eurRates.put("SEK", 10.31);
        eurRates.put("NZD", 1.67);
        eurRates.put("SGD", 1.59);
        eurRates.put("INR", 87.76);
        exchangeRates.put("EUR", eurRates);

        // Additional rate mappings can be added similarly for other base currencies
    }

    @Override
    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        return amount * getConversionRate(fromCurrency, toCurrency);
    }

    private double getConversionRate(String from, String to) {
        if (!exchangeRates.containsKey(from) || !exchangeRates.get(from).containsKey(to)) {
            throw new IllegalArgumentException("Currency conversion rate not available");
        }
        return exchangeRates.get(from).get(to);
    }

    @Override
    public double calculateLoanPayment(double principal, double annualRate, int termInYears, int paymentsPerYear, double balloonPayment) {
        double monthlyRate = annualRate / paymentsPerYear / 100;
        int totalPayments = termInYears * paymentsPerYear;
        double payment = (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -totalPayments));
        payment += balloonPayment / totalPayments;  // Amortize balloon payment across the term
        return payment;
    }

    @Override
    public double predictInvestmentReturn(double investment, double riskFactor, int years, String investmentType, double inflationRate) {
        double basicReturn = investment * Math.pow(1 + riskFactor, years);
        double adjustedReturn = adjustForInflation(basicReturn, inflationRate, years);
        return adjustForInvestmentType(adjustedReturn, investmentType);
    }

    private double adjustForInflation(double amount, double inflationRate, int years) {
        return amount / Math.pow(1 + inflationRate, years);
    }

    private double adjustForInvestmentType(double amount, String type) {
        // This could involve different calculations based on investment type
        switch (type) {
            case "conservative":
                return amount * 0.95; // Example modification for conservative investments
            case "aggressive":
                return amount * 1.10; // Example boost for aggressive investments
            default:
                return amount;
        }
    }
}
