package ElectricityMonitor;

class Device {
    private String name;
    private double hoursOfWork;
    private double wattsConsumed;

    public Device(String name, double hoursOfWork, double wattsConsumed) {
        this.name = name;
        this.hoursOfWork = hoursOfWork;
        this.wattsConsumed = wattsConsumed;
    }

    public double calculateElectricityConsumption() {
        double kilowattsConsumedPerDay = (wattsConsumed / 1000) * hoursOfWork;
        int daysInMonth = 30;
        return kilowattsConsumedPerDay * daysInMonth;
    }

}