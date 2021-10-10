package com.smitie.parkinglot;

public class Vehicle {
    private final String licensePlate;
    private final int spotsNeeded;
    private final VehicleType vehicleType;

    public Vehicle(String licensePlate, int spotsNeeded, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.spotsNeeded = spotsNeeded;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
