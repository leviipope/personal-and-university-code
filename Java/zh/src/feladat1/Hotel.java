package feladat1;

import java.util.Objects;

public class Hotel {
    private String hotelName;
    private int rooms;
    private int availableRooms;
    private int bookedRooms;

    /**
     * Constructor to initialize a hotel.
     *
     * @param hotelName      the name of the hotel
     * @param rooms          the total number of rooms in the hotel
     * @param availableRooms the number of rooms currently available
     * @param bookedRooms    the number of rooms currently booked
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
     *  Compares this hotel to another object for equality
     *
     * @param o the object to compare with this hotel
     * @return true is the specified object is equal to this hotel, false otherwise
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

    // 1/b
    /**
     * Checks if there are any available rooms in the hotel.
     *
     * @return true if there are available rooms, false otherwise
     */
    public boolean isRoomAvailable() {
        return availableRooms > 0;
    }


}


