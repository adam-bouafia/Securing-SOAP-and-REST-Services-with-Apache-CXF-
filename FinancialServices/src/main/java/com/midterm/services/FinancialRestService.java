// RESTful service implementation

package com.midterm.services;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/api")
@RolesAllowed("USER")  // Apply to all methods in this class
public class FinancialRestService {

    // Instance of FinancialServiceImpl to use its methods
    private FinancialServiceImpl financialService = new FinancialServiceImpl();

    @GET
    @Path("/currency/convert")
    public Response convertCurrency(@QueryParam("amount") double amount, 
                                    @QueryParam("from") String fromCurrency, 
                                    @QueryParam("to") String toCurrency) {
        try {
            double result = financialService.convertCurrency(amount, fromCurrency, toCurrency);
            return Response.ok(result).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/loan/calculate")
    @RolesAllowed("ADMIN")  // Specific method level security
    public Response calculateLoanPayment(@QueryParam("principal") double principal, 
                                         @QueryParam("rate") double rate, 
                                         @QueryParam("term") int termInYears,
                                         @QueryParam("paymentsPerYear") int paymentsPerYear,
                                         @QueryParam("balloonPayment") double balloonPayment) {
        try {
            double monthlyPayment = financialService.calculateLoanPayment(principal, rate, termInYears, paymentsPerYear, balloonPayment);
            return Response.ok(monthlyPayment).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error in calculating loan payment: " + e.getMessage()).build();
        }
    }


    @GET
    @Path("/investment/predict")
    public Response predictInvestmentReturn(@QueryParam("amount") double amount, 
                                            @QueryParam("risk") double riskFactor, 
                                            @QueryParam("years") int years,
                                            @QueryParam("type") String investmentType,
                                            @QueryParam("inflation") double inflationRate) {
        try {
            double returnValue = financialService.predictInvestmentReturn(amount, riskFactor, years, investmentType, inflationRate);
            return Response.ok(returnValue).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error in predicting investment return: " + e.getMessage()).build();
        }
    }
}
