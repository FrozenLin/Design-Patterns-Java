package FactoryMethodPattern;

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        // Creating a Tiger Factory
        AnimalFactory tigerFactory = new TigerFactory();
        // Creating a tiger using the Factory method
        Animal tiger = tigerFactory.createAnimal();
        tiger.speak();
        tiger.preferredAction();

        // Creating a Dog Factory
        AnimalFactory dogFactory = new DogFactory();
        // Creating a dog using the Factory method
        Animal dog = dogFactory.createAnimal();
        dog.speak();
        dog.preferredAction();
    }
}

