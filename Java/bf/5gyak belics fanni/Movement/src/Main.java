import interfaces.Animal;
import interfaces.Move;
import models.Horse;
import models.HorseComparator;
import models.Snail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Snail s1 = new Snail(0.77, 0.05, "Water");
        Animal s2 = new Snail(0.05, 0.3, "Earth");
        Move s3 = new Snail(0.1, 0.9, "Water");

        System.out.println(s1.getNumberOfLegs());
        System.out.println(s2.getNumberOfLegs());
        //System.out.println(s3.getNumberOfLegs());

        Horse h1 = new Horse(70, 140, 70,
                            "Samu", "Feher", LocalDate.of(2022, 02, 24));
        Horse h2 = new Horse(20, 280, 200,
                "Samu", "Barna", LocalDate.of(2018, 03, 15));
        Horse h3 = new Horse(40, 200, 450,
                "Fjord", "Feher", LocalDate.of(2022, 02, 24));

        ArrayList<Horse> stable = new ArrayList<>();
        stable.add(h1);
        stable.add(h2);
        stable.add(h3);

        System.out.println(stable);

        Collections.sort(stable, new Comparator<Horse>() {
            @Override
            public int compare(Horse o1, Horse o2) {
                int v1 = o1.getName().compareTo(o2.getName());
                if(v1 != 0) return v1;
                return (int) -(o1.getCarryingCapacityInKg() - o2.getCarryingCapacityInKg());
            }
        });

        System.out.println(stable);

        stable.sort(Horse::compareTo);
        System.out.println(stable);

        stable.sort(new HorseComparator());
        System.out.println(stable);



    }
}
