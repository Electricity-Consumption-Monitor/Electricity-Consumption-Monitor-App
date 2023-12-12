package ElectricityMonitor;

import org.junit.Test;
import static org.junit.Assert.*;

public class BillingDecoratorTest {

    @Test
    public void testCalculateTotalElectricityBill() {

        ElectricityComponent mockComponent = new ElectricityComponent() {
            @Override
            public double calculateTotalElectricityBill() {

                return 100.0;
            }
        };

        BillingDecorator billingDecorator = new BillingDecorator(mockComponent);
        double result = billingDecorator.calculateTotalElectricityBill();


        assertEquals(115.0, result, 0.001);
    }

}
