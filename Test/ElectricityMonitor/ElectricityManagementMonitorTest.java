package ElectricityMonitor;

import org.junit.Test;
import static org.junit.Assert.*;


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


}
