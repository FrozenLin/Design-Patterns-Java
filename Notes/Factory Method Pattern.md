### Factory Method Pattern

##### GOF Definition

> Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory method lets a class defer instantiation to subclasses.

##### Programmatic Example

In this case, 

```java
public interface Animal {
    void speak();

    void preferredAction();
}
```

Class Dog and Tiger.

```java
public class Dog implements Animal {
    public void speak() {
        System.out.println("Dog says: Bow-Wow.");
    }

    public void  preferredAction() {
        System.out.println("Dogs prefer barking...\n");
    }
}
```

```java
public class Tiger implements Animal {
    public void speak() {
        System.out.println("Tiger says: Halum.");
    }

    public void preferredAction() {
        System.out.println("Tigers prefer hunting...\n");
    }
}
```

createAnimal() method in the class AnimalFactory does not know if it will get a Dog or a Tiger. This decision will be taken by the subclasses i.e. DogFactory or TigerFactory.

```java
abstract class AnimalFactory {
    public abstract Animal createAnimal();
}
```

DogFactory and TigerFactory.

```java
public class DogFactory extends AnimalFactory {
    public Animal createAnimal() {
        // Creating a dog
        return new Dog();
    }
}
```

```java
public class TigerFactory extends AnimalFactory {
    public Animal createAnimal() {
        // Creating a tiger
        return new Tiger();
    }
}
```

Finally, the factory method class.

```java
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
```

Results

```markdown
Tiger says: Halum.
Tigers prefer hunting...

Dog says: Bow-Wow.
Dogs prefer barking...
```

##### Real World Example

getInstance() method of the java.text.NumberFormat class

createURLStream Handler(String protocal) of the java.net.URLStreamHandlerFactory

##### Analysis

It is evident that this pattern supports parallel class hierarchies.

AnimalFactory, DogFactory and TigerFactory are placed in one hierarchy.

Animal, Dog and Tiger are placed in another hierarchy.

