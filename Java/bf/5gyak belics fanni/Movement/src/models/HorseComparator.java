package models;

import java.util.Comparator;

public class HorseComparator implements Comparator<Horse> {

    //Nev, suly, teherbírás
    @Override
    public int compare(Horse o1, Horse o2) {
        int v1 = o1.getName().compareTo(o2.getName());
        if(v1 != 0) return v1;
        v1 = Double.compare(o1.weight, o2.weight);
        if(v1 != 0) return v1;
        return (int) (o1.getCarryingCapacityInKg() - o2.getCarryingCapacityInKg());

    }
}
