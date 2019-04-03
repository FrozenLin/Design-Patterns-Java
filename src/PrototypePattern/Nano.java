package PrototypePattern;

public class Nano extends BasicCar {
    // base price
    public int basePrice = 100000;

    public Nano(String m) {
        modelName = m;
    }

    @Override
    public BasicCar clone() throws CloneNotSupportedException {
        return (Nano) super.clone();
    }
}
