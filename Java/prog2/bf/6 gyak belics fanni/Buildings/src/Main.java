import Construction.Building;
import Construction.Room;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Building b1 = new Building("DEIK", "Kassai út 26");
        HashSet<Building> hs1 = new HashSet<>();
       hs1.add(new Building("DEIK", "Kassai út 26"));
       hs1.add(new Building("Kémia", "Egyetem tér 1"));
       hs1.add(new Building("Matek", "Egyetem tér 1"));
       hs1.add(new Building("Matek", "Egyetem tér 1"));
       hs1.add(b1);

        System.out.println(hs1);

        for(Building building : hs1){
            System.out.println(building);
        }

        System.out.println("-------------");

        TreeSet<Room> ts1 = new TreeSet<>(new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                int v1 = o1.getRoomId().compareTo(o2.getRoomId());
                return v1;
            }
        });
        Room r1 = new Room(b1, "F0", 240);
        ts1.add(r1);
        ts1.add(new Room(b1, "F0", 240));
        ts1.add(new Room(new Building("Kémia", "Egyetem tér 1"), "K10", 40));
        ts1.add(new Room(new Building("Kémia", "Egyetem tér 1"), "K20", 20));
        ts1.add(new Room(new Building("Főép", "Egyetem tér 1"), "1/3", 8));

        System.out.println(ts1);



    }
}