package com.example.carlosergio.rotation;

import android.icu.text.IDNA;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by CarloSergio on 10/03/2017.
 */

public class InfoPago implements Serializable {
    private final double mLoanAmount, mAnnualInterestRateInPercent, mTotalPayments, mMonthlyPayment;
    private final long mLoanPeriodInMonths;
    private final String mCurrencySymbol;

    public InfoPago(double loanAmount, double annualInterestRateInPercent,
                    long loanPeriodInMonths, String currencySymbol) {
        mLoanAmount = loanAmount;
        mAnnualInterestRateInPercent = annualInterestRateInPercent;
        mLoanPeriodInMonths = loanPeriodInMonths;
        mCurrencySymbol = currencySymbol;
        mMonthlyPayment = UtilesPrestamo.monthlyPayment(loanAmount,
                annualInterestRateInPercent,
                loanPeriodInMonths);
        mTotalPayments = mMonthlyPayment * mLoanPeriodInMonths;
    }

    public InfoPago(double loanAmount, double annualInterestRateInPercent,
                    long loanPeriodInMonths) {
        this(loanAmount, annualInterestRateInPercent, loanPeriodInMonths, "$");
    }

    public double getLoanAmount() {
        return (mLoanAmount);
    }

    public String getFormattedLoanAmount() {
        return (String.format("%s%,.2f", mCurrencySymbol, mLoanAmount));
    }

    public double getAnnualInterestRateInPercent() {
        return (mAnnualInterestRateInPercent);
    }

    public String getFormattedAnnualInterestRateInPercent() {
        return (String.format("%,.2f%%", mAnnualInterestRateInPercent));
    }

    public long getLoanPeriodInMonths() {
        return (mLoanPeriodInMonths);
    }

    public String getFormattedLoanPeriodInMonths() {
        return (String.format("%s", mLoanPeriodInMonths));
    }

    public String getCurrencySymbol() {
        return (mCurrencySymbol);
    }

    public double getMonthlyPayment() {
        return (mMonthlyPayment);
    }

    public String getFormattedMonthlyPayment() {
        return (String.format("%s%,.2f", mCurrencySymbol, mMonthlyPayment));
    }

    public double getTotalPayments() {
        return (mTotalPayments);
    }

    public String getFormattedTotalPayments() {
        return (String.format("%s%,.2f", mCurrencySymbol, mTotalPayments));
    }

}




