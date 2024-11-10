import Construction.Building;
import Construction.Room;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Room> rooms = new ArrayList<>();
        Building b1 = new Building("DEIK", "Kassai Campus 26");
        Building b2 = new Building("Kémia", "Egyetem tér 1");
        Building b3 = new Building("Matek", "Egyetem tér 1");

        rooms.add(new Room(b1, "F01", 40));
        rooms.add(new Room(b1, "104", 18));
        rooms.add(new Room(b2, "K10", 18));
        rooms.add(new Room(b2, "K20", 30));
        rooms.add(new Room(b3, "Matek1", 30));
        rooms.add(new Room(b3, "Matek2", 30));

        HashMap<Building, ArrayList<Room>> hm1 = new HashMap<>();

        for(var v1 : rooms){
            ArrayList al;
            if(hm1.containsKey(v1.getBuilding())){
                al = hm1.get(v1.getBuilding());
                al.add(v1);
                hm1.put(v1.getBuilding(), al);
            }else
            {
                al = new ArrayList<>();
                al.add(v1);
                hm1.put(v1.getBuilding(), al);
            }
        }

        System.out.println(hm1);

        TreeMap<Building, Room> tr1 = new TreeMap<>();
        tr1.put(b3, new Room(b3, "F09", 200));




    }
}