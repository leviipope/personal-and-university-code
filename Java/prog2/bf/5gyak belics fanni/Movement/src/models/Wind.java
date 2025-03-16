package models;

import interfaces.Move;

public class Wind implements Move {
    String direction;
    double speedInMeterPerSec;

    public Wind(String direction, double speedInMeterPerSec) {
        this.direction = direction;
        this.speedInMeterPerSec = speedInMeterPerSec;
    }

    @Override
    public double getSpeedInMeterPerSec() {
        return speedInMeterPerSec;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Wind{");
        sb.append("direction='").append(direction).append('\'');
        sb.append(", speedInMeterPerSec=").append(speedInMeterPerSec);
        sb.append('}');
        return sb.toString();
    }
}
