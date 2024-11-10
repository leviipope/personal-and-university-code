package org.types;

public class Car extends Vehicle{
    boolean isEngineWorking;
    int horsepower;

    public Car(String lincesePlate){
        super(lincesePlate, 4);
        isEngineWorking = false;
    }

    public Car(String licensePlate, int horsePower){
        this(licensePlate);
        this.horsepower = horsePower;
    }

    public boolean isEngineWorking() {
        return isEngineWorking;
    }

    public void setEngineWorking(boolean engineWorking) {
        isEngineWorking = engineWorking;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("isEngineWorking=").append(isEngineWorking);
        sb.append(", horsepower=").append(horsepower);
        sb.append(", id='").append(id).append('\'');
        sb.append(", status=").append(status);
        sb.append(", numberOfWheels=").append(numberOfWheels);
        sb.append('}');
        return sb.toString();
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public void setMove() {
        super.setMove();
        isEngineWorking = true;
    }

    @Override
    public void setParked() {
        super.setParked();
        isEngineWorking = false;
    }

    @Override
    public void setStop() {
        super.setStop();
        isEngineWorking = true;
    }
}
