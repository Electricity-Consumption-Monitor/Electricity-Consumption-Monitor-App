package ElectricityMonitor;

import java.util.ArrayList;
import java.util.List;

class Room implements ElectricityComponent {
    private List<Device> devices;

    public Room() {
        devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    @Override
    public double calculateTotalElectricityBill() {
        double totalConsumption = 0.0;
        for (Device device : devices) {
            totalConsumption += device.calculateElectricityConsumption();

        }
        return totalConsumption;
    }
}