package org.types;

import java.util.Objects;

public class Vehicle {
    String id;
    int numberOfWheels;
    VehicleStatus status;

    public Vehicle(String id){
        this.id = id;
        status = VehicleStatus.PARKED;
    }

    public void setParked(){
        status = VehicleStatus.PARKED;
    }

    public void setStop(){
        status = VehicleStatus.STOP;
    }

    public void setMove(){
        status = VehicleStatus.MOVE;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vehicle{");
        sb.append("id='").append(id).append('\'');
        sb.append(", numberOfWheels=").append(numberOfWheels);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    public Vehicle(String id, int numberOfWheels){
        this(id);
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return Objects.equals(id, vehicle.id);
    }

    public String getId() {
        return id;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public VehicleStatus getStatus() {
        return status;
    }
}
