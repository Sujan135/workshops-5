package com.yearup.contract;

import com.yearup.dealership.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ContractDataManager {

    public void saveContract(Contract contract) {

        String filePath = "src/resources/contracts.csv";
        StringBuilder line = new StringBuilder();

        if (contract instanceof SalesContract) {
            SalesContract sale = (SalesContract) contract;
            Vehicle v = sale.getVehicle();

            line.append(String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                    sale.getDate(),
                    sale.getCustomerName(),
                    sale.getCustomerEmail(),
                    v.getVin(),
                    v.getYear(),
                    v.getMake(),
                    v.getModel(),
                    v.getType(),
                    v.getColor(),
                    v.getOdometer(),
                    v.getPrice(),
                    sale.getSalesTaxAmount(),
                    sale.getRecordingFee(),
                    sale.getProcessingFee(),
                    sale.getTotalPrice(),
                    sale.isFinanced() ? "YES" : "NO",
                    sale.getMonthlyPayment()

                    ));

        } else  if (contract instanceof LeaseContract) {
            LeaseContract lease = (LeaseContract) contract;
            Vehicle v = lease.getVehicle();

            line.append(String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f",
                    lease.getDate(),
                    lease.getCustomerName(),
                    lease.getCustomerEmail(),
                    v.getVin(),
                    v.getYear(),
                    v.getMake(),
                    v.getModel(),
                    v.getType(),
                    v.getColor(),
                    v.getOdometer(),
                    v.getPrice(),
                    lease.getExpectedEndingValue(),
                    lease.getLeaseFee(),
                    lease.getMonthlyPayment()
                    ));
        }


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(line.toString());
            writer.newLine();
        } catch (IOException e ) {
            e.printStackTrace();
        }

    }
}
