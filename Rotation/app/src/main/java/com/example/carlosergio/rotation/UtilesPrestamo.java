package com.example.carlosergio.rotation;

/**
 * Created by CarloSergio on 10/03/2017.
 */

public class UtilesPrestamo{ /** Calculates the monthly payment for a loan of a given amount and
 *  with a given interest rate and period.
 *
 * @param loanAmount the loan amount (principal) in same units as the return value. For example,
 *                   if you supply dollars for the loan amount, then the returned monthly payment
 *                   will also be in dollars.
 * @param annualInterestRateInPercent the yearly interest rate as a percent, not as decimal.
 *                                    For example, 12.5 would mean a 12.5% annual interest rate.
 * @param loanPeriodInMonths the number of months over which the loan will be repaid.
 * @return the payment per month, in the same units as the loan amount.
 */

public static double monthlyPayment(double loanAmount,
                                    double annualInterestRateInPercent,
                                    long loanPeriodInMonths) {
    if (annualInterestRateInPercent <= 0) {
        annualInterestRateInPercent = 0.0000001;
    }
    double monthlyInterestRate = annualInterestRateInPercent / 1200.0;
    double numerator = loanAmount * monthlyInterestRate;
    double denominator =
            1 - Math.pow(1 + monthlyInterestRate, -1 * loanPeriodInMonths);
    return (numerator / denominator);
}
}

