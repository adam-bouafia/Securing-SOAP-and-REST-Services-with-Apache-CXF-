// Interface for SOAP services

package com.midterm.services;

import javax.annotation.security.RolesAllowed;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public interface FinancialServices {
	@WebMethod
	@RolesAllowed("USER")
	double convertCurrency(double amount, String fromCurrency, String toCurrency);

	@WebMethod
	@RolesAllowed("ADMIN")
	double calculateLoanPayment(double principal, double annualRate, int termInYears, int paymentsPerYear,
			double balloonPayment);

	@WebMethod
	@RolesAllowed("USER")
	double predictInvestmentReturn(double investment, double riskFactor, int years, String investmentType,
			double inflationRate);
}
