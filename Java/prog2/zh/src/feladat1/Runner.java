package feladat1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        String etelFalj = args[0];
        // 1/d
        Map<String,Hotel> hotelMap = new HashMap<>();
        try (Scanner sc = new Scanner(new File(etelFalj))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(";");
                String hotelName = parts[0];
                int rooms = Integer.parseInt(parts[1]);
                int availableRooms = Integer.parseInt(parts[2]);
                int bookedRooms = Integer.parseInt(parts[3]);

                hotelMap.put(hotelName, new Hotel(hotelName, rooms, availableRooms, bookedRooms));
            }

            System.out.println("Loaded successfully");
            for(Map.Entry<String,Hotel> entry : hotelMap.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }

        // 1/f
        List<Hotel> availableHotels = findAvailableHotels(hotelMap);
        Collections.sort(availableHotels, new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                int v = o1.getRooms()-o2.getRooms();
                if(v!=0) return v;
                return o1.getHotelName().compareTo(o2.getHotelName());
            }
        });
        System.out.println("\nHotels with available rooms: ");
        for(Hotel hotel : availableHotels){
            System.out.println(hotel.getHotelName());
        }
    }

    // 1/e
    public static List<Hotel> findAvailableHotels(Map<String, Hotel> hotelmap){
        List<Hotel> availableHotels = new ArrayList<>();
        for(Hotel hotel : hotelmap.values()){
            if(hotel.getAvailableRooms()>0){
                availableHotels.add(hotel);
            }
        }
        return availableHotels;
    }
}
