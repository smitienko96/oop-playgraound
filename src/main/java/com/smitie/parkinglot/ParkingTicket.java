package com.smitie.parkinglot;

import java.time.LocalDateTime;
import java.util.List;

public final class ParkingTicket {

    private final Vehicle vehicle;
    private final LocalDateTime releaseDate;
    private final List<String> parkingSpotsLabels;
    private final String floorName;

    public ParkingTicket(Vehicle vehicle, List<String> parkingSpotsLabels, String floorName) {
        this.vehicle = vehicle;
        releaseDate = LocalDateTime.now();
        this.parkingSpotsLabels = parkingSpotsLabels;
        this.floorName = floorName;
    }

    protected Vehicle getVehicle() {
        return vehicle;
    }

    protected LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public List<String> getParkingSpotsLabels() {
        return parkingSpotsLabels;
    }

    public String getFloorName() {
        return floorName;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "vehicle=" + vehicle +
                ", releaseDate=" + releaseDate +
                ", parkingSpotsLabels=" + parkingSpotsLabels +
                ", floorName='" + floorName + '\'' +
                '}';
    }
}
