package com.yearup.contract;

import com.yearup.dealership.Vehicle;

public class LeaseContract extends Contract{
    private final double LeaseFeeRate = 0.07;
    private final double LeaseInterestRate = 0.04 / 12;
    private final int LeaseMonths = 36;

    private double expectedEndingValue;
    private  double LeaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle, double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, vehicle);
        this.expectedEndingValue = expectedEndingValue;
        LeaseFee = leaseFee;
    }

    public double getLeaseFeeRate() {
        return LeaseFeeRate;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }


    @Override
    public double getTotalPrice() {
        totalPrice = LeaseFee+ (getVehicle().getPrice() - expectedEndingValue);
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double principal = getTotalPrice();

        monthlyPayment = (principal * LeaseInterestRate) / (1- Math.pow(1 + LeaseInterestRate, -LeaseMonths));
        return monthlyPayment;
    }
}
