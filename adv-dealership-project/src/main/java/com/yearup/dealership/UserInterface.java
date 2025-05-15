package com.yearup.dealership;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public void display() {
        init();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    processAllVehiclesRequest();
                    break;
                case 2:
                    processVehiclesByPriceRange();
                    break;
                case 3:
                    processVehiclesByMakeModel();
                    break;
                case 4:
                    System.out.println("Exiting..");
                    return;
                default:
                    System.out.println("Invalid command. Try again.");
                    break;
            }
        }
    }


    private void displayMenu() {
        System.out.println("-- Dealership Menu --");
        System.out.println("1. View all vehicles");
        System.out.println("2. View vehicles by price range");
        System.out.println("3. View vehicles by make/model");
        System.out.println("4. Exit");
        System.out.println(" Enter your command");
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealerShip();
    }

    private void displayVehicles(List<Vehicle> vehicles){
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        }else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.getYear()
                        + " " + vehicle.getMake() +
                        " " + vehicle.getModel()
                        + " - $" + vehicle.getPrice());
            }
        }
    }

    private void processAllVehiclesRequest() {
        if (dealership != null) {
            displayVehicles(dealership.getAllVehicles());
        }else {
            System.out.println("Dealership not found.");
        }
    }

    private void processVehiclesByPriceRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.println("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        List<Vehicle> filtered = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(filtered);

    }
    private void processVehiclesByMakeModel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        List<Vehicle> filtered = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(filtered);

    }

}
