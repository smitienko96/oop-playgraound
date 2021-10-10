package com.smitie.parkinglot;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class ParkingFloor {

    private final String name;
    private final int totalSpots;
    private final Map<String, ParkingSpot> parkingSpots = new LinkedHashMap<>();
    private Set<ParkingTicket> parkingTickets = new HashSet<>();

    public ParkingFloor(String name, int totalSpots) {
        this.name = name;
        this.totalSpots = totalSpots;

        initialize();
    }


    protected ParkingTicket parkVehicle(Vehicle vehicle) {
        List<ParkingSpot> spotsToParkVehicle = findSpotsToParkVehicle(vehicle);
        if (spotsToParkVehicle.isEmpty()) throw new RuntimeException("Not enough spots to park a vehicle: " + vehicle);
        assignVehicleToParkingSpots(spotsToParkVehicle, vehicle);

        ParkingTicket ticket = releaseParkingTicket(vehicle, spotsToParkVehicle);
        registerParkingTicket(ticket);
        return ticket;
    }

    protected boolean unparkVehicle(Vehicle vehicle) {

        ParkingTicket parkingTicket = findParkingTicket(vehicle);

        if(!parkingTickets.contains(parkingTicket)) {
            return false;
        }

        int countSpots = 0;
        for(ParkingSpot pl: parkingSpots.values()) {
            if(pl.getVehicle()!= null && pl.getVehicle().equals(vehicle)) {
                boolean success = pl.removeVehicle();
                if(!success) {
                    return false;
                }

                if(++countSpots == vehicle.getSpotsNeeded()) {
                    break;
                }
            }
        }

        unregisterParkingTicket(parkingTicket);

        return true;
    }

    protected boolean unparkVehicle(ParkingTicket parkingTicket) {

        if(!parkingTickets.contains(parkingTicket)) {
            throw new RuntimeException("This ticket is not in our system!");
        }

        List<String> spots = parkingTicket.getParkingSpotsLabels();
        for(String spot: spots) {
            boolean success = parkingSpots.get(spot).removeVehicle();
            if(!success) {
                return false;
            }
        }

        unregisterParkingTicket(parkingTicket);

        return true;

    }

    protected boolean isFull(VehicleType type) { return false; }


    private void assignVehicleToParkingSpots(List<ParkingSpot> spots, Vehicle vehicle) {
        spots.forEach(spot -> spot.assign(vehicle));
    }

    private void initialize() {
        for (int i = 0; i < totalSpots; i++) {
            parkingSpots.put("#" + i, new ParkingSpot("#" + 1, this));
        }
    }

    private List<ParkingSpot> findSpotsToParkVehicle(Vehicle vehicle) {
        int count = 0;
        List<ParkingSpot> freeSpots = new ArrayList<>();
        int spotsNeeded = vehicle.getSpotsNeeded();

        for (int i = 1; i <= totalSpots; i++) {
            if (parkingSpots.get("#" + i).isFree()) {
                count++;
                freeSpots.add(parkingSpots.get("#" + i));
            } else {
                count = 0;
                freeSpots.clear();
            }
            if (count == spotsNeeded)
                return freeSpots;
        }

        freeSpots.clear();
        return freeSpots;
    }

    private ParkingTicket releaseParkingTicket(Vehicle vehicle, List<ParkingSpot> parkingSpots) {
        List<String> spotsLabels = parkingSpots.stream()
                .map(ParkingSpot::getLabel)
                .collect(toList());

        return new ParkingTicket(vehicle, spotsLabels, this.name);
    }

    private void registerParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTickets.add(parkingTicket);
    }

    private ParkingTicket findParkingTicket(Vehicle vehicle) {
       return this.parkingTickets.stream().filter(ticket -> this.parkingTickets.contains(ticket))
                .findFirst().orElseThrow(() -> new RuntimeException("Specified ticket not found."));
    }

    private boolean unregisterParkingTicket(ParkingTicket parkingTicket) {
        return this.parkingTickets.remove(parkingTicket);
    }

    public String getName() {
        return name;
    }

    public int getTotalSpots() {
        return totalSpots;
    }

    public Map<String, ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public Set<ParkingTicket> getParkingTickets() {
        return parkingTickets;
    }

}
