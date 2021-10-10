package com.smitie.parkinglot;

public class ParkingSpot {

    private boolean free;
    private Vehicle vehicle;

    private final String label;
    private final ParkingFloor parkingFloor;

    protected ParkingSpot(String label, ParkingFloor parkingFloor) {
        this.label = label;
        this.parkingFloor = parkingFloor;
    }

    protected boolean assign(Vehicle vehicle) {

        System.out.println("Assign " + label + " at floor "
                + parkingFloor.getName() +  " to " + vehicle);

        this.vehicle = vehicle;
        this.free = false;

        return true;
    }

    protected boolean removeVehicle() {

        System.out.println("Free " + label
                + " at floor " + parkingFloor.getName() +" of " + vehicle);

        this.vehicle = null;
        this.free = true;
        return true;
    }

    public boolean isFree() {
        return free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                ", label='" + label + '\'' +
                '}';
    }
}
