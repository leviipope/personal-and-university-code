package feladat1;

import java.util.Objects;

public class Hotel {
    private String hotelName;
    private int rooms;
    private int availableRooms;
    private int bookedRooms;

    /**
     *
     * @param hotelName
     * @param rooms
     * @param availableRooms
     * @param bookedRooms
     */
    public Hotel(String hotelName, int rooms, int availableRooms, int bookedRooms) {
        this.hotelName = hotelName;
        this.rooms = rooms;
        this.availableRooms = availableRooms;
        this.bookedRooms = bookedRooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getRooms() {
        return rooms;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public int getBookedRooms() {
        return bookedRooms;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hotel{");
        sb.append("hotelName='").append(hotelName).append('\'');
        sb.append(", rooms=").append(rooms);
        sb.append(", availableRooms=").append(availableRooms);
        sb.append(", bookedRooms=").append(bookedRooms);
        sb.append('}');
        return sb.toString();
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel hotel)) return false;
        return rooms == hotel.rooms && Objects.equals(hotelName, hotel.hotelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelName, rooms);
    }

    /**
     *
     * @return
     */
    public boolean IsRoomAvailable(){
        return availableRooms>0;
    }
}
