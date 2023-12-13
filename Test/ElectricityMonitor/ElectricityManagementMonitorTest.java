package ElectricityMonitor;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


public class ElectricityManagementMonitorTest {

    @Test
    public void testCalculateTotalElectricityBill() {
        ElectricityManagementMonitor monitor = ElectricityManagementMonitor.getInstance();


        Building building = new Building("Test Building");
        BillingDecorator billingDecorator = new BillingDecorator(building);
        monitor.addComponent(billingDecorator);

        double totalBill = monitor.calculateTotalElectricityBill();
        assertEquals(0.0, totalBill, 0.001);
    }

    @Test
    public void testMain() {
        String input = "Test Building\n2\nRoom 1\n2\nDevice 1\n1.5\n100.0\nDevice 2\n2.0\n150.0\nRoom 2\n1\nDevice 3\n3.0\n200.0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ElectricityManagementMonitor.main(null);

        System.setIn(System.in);
        System.setOut(System.out);

        String expectedOutput = "Enter the name of the building: " +
                "Enter the number of rooms in Test Building: " +
                "\nRoom 1:" +
                "\nEnter the number of devices in this room: " +
                "\nDevice 1:" +
                "\nEnter the name of the device: " +
                "Enter how many hours the device works: " +
                "Enter how many Watts does it consume: " +
                "\nDevice 2:" +
                "\nEnter the name of the device: " +
                "Enter how many hours the device works: " +
                "Enter how many Watts does it consume: " +
                "\nRoom 2:" +
                "\nEnter the number of devices in this room: " +
                "\nDevice 3:" +
                "\nEnter the name of the device: " +
                "Enter how many hours the device works: " +
                "Enter how many Watts does it consume: " +
                "\nTotal electricity bill for the entire system: $0.0\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
