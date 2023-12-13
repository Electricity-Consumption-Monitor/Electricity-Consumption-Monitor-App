package ElectricityMonitor;

import org.junit.Test;
import static org.junit.Assert.*;

public class BuildingTest {

    @Test
    public void testAddRoom() {

        Building building = new Building("Test Building");

        Room room1 = new Room();
        Room room2 = new Room();

        building.addRoom(room1);
        building.addRoom(room2);

        assertEquals(2, building.getRooms().size());
        assertTrue(building.getRooms().contains(room1));
        assertTrue(building.getRooms().contains(room2));
    }

    @Test
    public void testCalculateTotalElectricityBill() {
        Building building = new Building("Test Building");

        Room room1 = new Room();
        Room room2 = new Room();

        building.addRoom(room1);
        building.addRoom(room2);

        Device device1 = new Device("Device 1", 5.0, 100.0);
        Device device2 = new Device("Device 2", 5.0, 150.0);

        room1.addDevice(device1);
        room2.addDevice(device2);

        double totalBill = building.calculateTotalElectricityBill();

        // Update the expected result to account for the multiplication by 0.18
        assertEquals(6.75, totalBill, 0.001);
    }
    @Test
    public void testGetName() {

        Building building = new Building("Test Building");

        assertEquals("Test Building", building.getName());
    }
}
