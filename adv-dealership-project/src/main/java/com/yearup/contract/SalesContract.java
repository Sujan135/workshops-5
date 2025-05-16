package com.yearup.contract;

import com.yearup.dealership.Vehicle;

public class SalesContract extends Contract{
    private final double SalesTaxRate = 0.05;
    private final double RecordingFee = 100.0;
    private final double ProcessingFeeLow = 295.0;
    private final double ProcessingFeeHigh = 495.0;
    private  boolean financed;

    private final double salesTaxAmount;
    private final double processingFee;


    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean financed) {
        super(date, customerName, customerEmail, vehicle);
        this.financed = financed;

        double price = vehicle.getPrice();
        this.salesTaxAmount = price * SalesTaxRate;
        this.processingFee = price < 10000 ? ProcessingFeeLow : ProcessingFeeHigh;
    }

    public boolean isFinanced() {
        return financed;
    }

    public void setFinanced(boolean financed) {
        this.financed = financed;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public double getRecordingFee() {
        return RecordingFee;
    }

    @Override
    public double getTotalPrice() {
        double price = getVehicle().getPrice();
        double salesTax = price * SalesTaxRate;
        double processingFee;

        if (price < 10000) {
            processingFee = ProcessingFeeLow;
        } else {
            processingFee = ProcessingFeeHigh;
        }

        totalPrice = price + salesTax + RecordingFee + processingFee;
        return  totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        if (!financed) {
            monthlyPayment = 0;
            return 0;
        }
        double principal = getTotalPrice();
        double interestRate;
        int months;

        if (principal > 10000) {
            interestRate = 0.0425 / 12;
            months = 48;
        } else {
            interestRate = 0.0525 / 12;
            months = 24;
        }

        monthlyPayment = (principal * interestRate) / (1 - Math.pow(1 + interestRate, -months));
        return  monthlyPayment;

    }
}
