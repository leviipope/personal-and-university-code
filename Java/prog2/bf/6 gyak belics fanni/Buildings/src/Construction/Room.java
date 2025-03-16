package Construction;

import java.util.ArrayList;

public class Room {
    Building building;
    String roomId;
    int numberOfSeats;
    ArrayList<String> attributes;

    public Room(Building building, String roomId, int numberOfSeats){
        this.building = building;
        this.roomId = roomId;
        this.numberOfSeats = numberOfSeats;
        this.attributes = new ArrayList<>();
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void addAttribute(String attr){
        attributes.add(attr);
    }

    public Building getBuilding() {
        return building;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Room{");
        sb.append("building=").append(building);
        sb.append(", roomId='").append(roomId).append('\'');
        sb.append(", numberOfSeats=").append(numberOfSeats);
        sb.append(", attributes=").append(attributes);
        sb.append('}');
        return sb.toString();
    }
}
