package com.yearup.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);

    }

    public List<Vehicle> getAllVehicles() {
        return  inventory;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> filtered = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max){
                filtered.add(v);
            }
        }
        return filtered;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> filtered = new ArrayList<>();
        for (Vehicle v : inventory){
            if (v.getMake().equalsIgnoreCase(make) && v.getMake().equalsIgnoreCase(model)) {
                filtered.add(v);
            }
        }

        return filtered;
    }

    public List<Vehicle> getVehiclesByYear (int min, int max) {
        List<Vehicle> filtered = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getYear() >= min && v.getYear() <= max) {
                filtered.add(v);
            }
        }

        return filtered;
    }

    public List<Vehicle> getVehiclesByColor (String color) {
        List<Vehicle> filtered = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color)){
                filtered.add(v);
            }
        }

        return filtered;
    }

    public List<Vehicle> getVehiclesByMileage (int min, int max) {
        List<Vehicle> filtered = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getOdometer() >= min && v.getOdometer() <= max) {
                filtered.add(v);
            }
        }
        return filtered;
    }

    public List<Vehicle> getVehiclesByType (String VehicleType) {
        return null;
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }


}
