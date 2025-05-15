package com.yearup.dealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    private static final String filePath = "src/main/resources/inventory.csv";

    public Dealership getDealerShip() {
        Dealership dealership = null;
//        Dealership dealership = getDealerShip();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String dealershipInfo;
            if (( dealershipInfo= reader.readLine()) != null) {
                String[] infoParts = dealershipInfo.split("\\|");
                String name = infoParts[0];
                String address = infoParts[1];
                String phone = infoParts[2];

                dealership = new Dealership(name, address, phone);

            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 8) {
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String type = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                    if (dealership != null) {
                        dealership.addVehicle(vehicle);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership){
        return;
    }
}
