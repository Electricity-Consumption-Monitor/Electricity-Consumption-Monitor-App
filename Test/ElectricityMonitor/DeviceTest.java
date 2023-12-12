package ElectricityMonitor;

import static org.junit.Assert.*;

public class DeviceTest {

    @org.junit.Test
    public void testCalculateElectricityConsumption() {

        Device device = new Device("Test Device", 5.0, 100.0);
        double expectedConsumption = 15.0;

        double actualConsumption = device.calculateElectricityConsumption();
        assertEquals(expectedConsumption, actualConsumption, 0.001);
    }
}
