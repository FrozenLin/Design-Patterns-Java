package StrategyPattern;

public class StrategyPatternExample {
    public static void main(String[] args) {
        Vehicle vehicleContext = new Boat();
        vehicleContext.showMe();
        vehicleContext.showTransportMedium();
        vehicleContext = new Aeroplane();
        vehicleContext.showMe();
        vehicleContext.showTransportMedium();
    }
}
