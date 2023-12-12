package ElectricityMonitor;

import java.util.ArrayList;
import java.util.List;


class Building implements ElectricityComponent {
    private String name;
    private List<Room> rooms;

    public Building(String name) {
        this.name = name;
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public double calculateTotalElectricityBill() {
        double totalElectricityBill = 0.0;
        for (Room room : rooms) {
            totalElectricityBill += room.calculateTotalElectricityBill();
        }
        return totalElectricityBill * 0.18;
    }

    public List<Room> getRooms() {
        return rooms;
    }
    public String getName() {
        return name;
    }
}
