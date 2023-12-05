package ElectricityMonitor;

class BillingDecorator implements ElectricityComponent {
    private ElectricityComponent component;

    public BillingDecorator(ElectricityComponent component) {
        this.component = component;
    }

    @Override
    public double calculateTotalElectricityBill() {
        // Add the 15% Tax.
        double additionalCost = component.calculateTotalElectricityBill() * 0.15;
        return component.calculateTotalElectricityBill() + additionalCost;
    }
}

