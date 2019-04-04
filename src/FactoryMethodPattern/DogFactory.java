package FactoryMethodPattern;

public class DogFactory extends AnimalFactory {
    public Animal createAnimal() {
        // Creating a dog
        return new Dog();
    }
}
