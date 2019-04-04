package FactoryMethodPattern;

public class TigerFactory extends AnimalFactory {
    public Animal createAnimal() {
        // Creating a tiger
        return new Tiger();
    }
}
