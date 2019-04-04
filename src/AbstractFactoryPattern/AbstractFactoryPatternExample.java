package AbstractFactoryPattern;

public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        AnimalFactory myAnimalFactory;
        Dog myDog;
        Tiger myTiger;

        // Making a wild dog through WildAnimalFactory
        myAnimalFactory = new WildAnimalFactory();
        myDog = myAnimalFactory.createDog();
        myDog.speak();
        myDog.preferredAction();

        // Making a wild tiger through WildAnimalFactory
        myTiger = myAnimalFactory.createTiger();
        myTiger.speak();
        myTiger.preferredAction();

        // Making a pet dog through PetAnimalFactory
        myAnimalFactory = new PetAnimalFactory();
        myDog = myAnimalFactory.createDog();
        myDog.speak();
        myDog.preferredAction();

        // Making a pet tiger through PetAnimalFactory
        myTiger = myAnimalFactory.createTiger();
        myTiger.speak();
        myTiger.preferredAction();
    }
}
