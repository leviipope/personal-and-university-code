package feladat1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        String file = args[0];

        Map<String, Hotel> hotelMap = new HashMap<>();
        try(Scanner sc = new Scanner(new File(file))){
            while(sc.hasNextLine()){
                String line =sc.nextLine();
                String[] parts = line.split(";");
                String hotelName = parts[0];
                int rooms = Integer.parseInt(parts[1]);
                int availableRooms = Integer.parseInt(parts[2]);
                int bookedRooms = Integer.parseInt(parts[3]);
                hotelMap.put(hotelName, new Hotel(hotelName,rooms,availableRooms,bookedRooms));

            }

            List<Hotel> goHotelek = findAvailableHotels(hotelMap);
            Collections.sort(goHotelek, new Comparator<Hotel>() {
                @Override
                public int compare(Hotel o1, Hotel o2) {
                    int v = o1.getAvailableRooms()-o2.getAvailableRooms();
                    if(v!=0) return v;
                    return o1.getHotelName().compareTo(o2.getHotelName());
                }
            });
            for(Hotel hotel : goHotelek){
                System.out.println(hotel);
            }
        }
    }

    public static List<Hotel> findAvailableHotels(Map<String,Hotel> hotelMap){
        List<Hotel> hotelList = new ArrayList<>();
        for(Hotel hotel : hotelMap.values()){
            if (hotel.getAvailableRooms()>0){
                hotelList.add(hotel);
            }
        }
        return hotelList;
    }
}
