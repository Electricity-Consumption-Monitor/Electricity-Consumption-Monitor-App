package ElectricityMonitor;

class BillingDecorator implements ElectricityComponent {
    private ElectricityComponent component;

    public BillingDecorator(ElectricityComponent component) {
        this.component = component;
    }

    @Override
    public double calculateTotalElectricityBill() {
        double additionalCost = component.calculateTotalElectricityBill() * 0.15;
        return component.calculateTotalElectricityBill() + additionalCost;
    }

}

