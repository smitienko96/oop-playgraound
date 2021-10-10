package com.smitie.parkinglot.system;

import com.smitie.parkinglot.ParkingTicket;
import com.smitie.parkinglot.VehicleType;

public interface Parking {

     ParkingTicket parkVehicleBtn(String licensePlate, VehicleType type);
     boolean unparkVehicleBtn(String licensePlate, VehicleType type);
     boolean unparkVehicleBtn(ParkingTicket parkingTicket);
}
