package BuilderPattern;

public class BuilderPatternExample {
    public static void main(String[] args) {
        Director director = new Director();
        Builder fordCar = new Car("Ford");
        Builder hondaMotorcycle = new MotorCycle("Honda");

        // Making car
        director.construct(fordCar);
        Product p1 = fordCar.getVehicle();
        p1.showProduct();

        // Making motorcycle
        director.construct(hondaMotorcycle);
        Product p2 = hondaMotorcycle.getVehicle();
        p2.showProduct();
    }
}
