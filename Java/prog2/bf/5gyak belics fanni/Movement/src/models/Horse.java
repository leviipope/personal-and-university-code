package models;

import interfaces.Animal;
import interfaces.MeansOfTransport;

import java.time.LocalDate;

public class Horse implements Animal, MeansOfTransport {
    double speedInMeterPerSec;
    double carryingCapacityInKg;
    String sound = "Neigh";
    double weight;
    int numberOfLegs = 4;
    String name;
    String color;
    LocalDate birthDate;

    public Horse(double speedInMeterPerSec, double carryingCapacityInKg,
                 double weight, String name, String color,
                 LocalDate birthDate) {
        this.speedInMeterPerSec = speedInMeterPerSec;
        this.carryingCapacityInKg = carryingCapacityInKg;
        this.weight = weight;
        this.name = name;
        this.color = color;
        this.birthDate = birthDate;
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
    public double getCarryingCapacityInKg() {
        return carryingCapacityInKg;
    }

    @Override
    public double getWeightInKg() {
        return weight;
    }

    @Override
    public double getSpeedInMeterPerSec() {
        return speedInMeterPerSec;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Horse{");
        sb.append("speedInMeterPerSec=").append(speedInMeterPerSec);
        sb.append(", carryingCapacityInKg=").append(carryingCapacityInKg);
        sb.append(", sound='").append(sound).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", numberOfLegs=").append(numberOfLegs);
        sb.append(", name='").append(name).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }

    //szin, birthDate
    public int compareTo(Horse o2){
        int v1 = this.color.compareTo(o2.color);
        if(v1 != 0) return v1;

        v1 = this.birthDate.compareTo(o2.birthDate);
        return v1;
    }

}
