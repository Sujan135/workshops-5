package com.yearup.dealership;

public class Program {
    public static void main(String[] args) {

        Dealership dealership = new Dealership("A", "B", "c" );

        Vehicle vehicle = new Vehicle(777, 2000, "BMW", "R", "X", "Blue", 45, 800.00);

        dealership.addVehicle(vehicle);

        for (Vehicle vehicle1 : dealership.getAllVehicles()) {
            System.out.println(vehicle1.getYear()+ " " + vehicle1.getMake() + " " + vehicle1.getModel() + " -$" + vehicle1.getPrice());
        }

        UserInterface userInterface = new UserInterface();
        userInterface.setDealership(dealership);

        userInterface.display();
    }
}
