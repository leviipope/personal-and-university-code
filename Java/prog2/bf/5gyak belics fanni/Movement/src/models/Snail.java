package models;

import interfaces.Animal;

public class Snail implements Animal {
    double speedInMeterPerSec;
    String sound = "";
    double weight;
    int numberOfLegs = 0;
    String snailType;

    public Snail(double speedInMeterPerSec, double weight, String snailType) {
        this.speedInMeterPerSec = speedInMeterPerSec;
        this.weight = weight;
        this.snailType = snailType;
    }

    @Override
    public String getSound() {
        return sound;
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public double getWeightInKg() {
        return weight;
    }

    @Override
    public double getSpeedInMeterPerSec() {
        return speedInMeterPerSec;
    }

    public String getSnailType() {
        return snailType;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Snail{");
        sb.append("speedInMeterPerSec=").append(speedInMeterPerSec);
        sb.append(", sound='").append(sound).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", numberOfLegs=").append(numberOfLegs);
        sb.append(", snailType='").append(snailType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
