### Abstarct Factory Pattern

##### GoF Definition

> Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

##### Programmatic Example

AnimalFactory is an interface that are treated as the abstract factory.

```java
public interface AnimalFactory {
    Dog createDog();

    Tiger createTiger();
}
```

Two concrete factories: WildAnimalFactory and PetAnimalFactory.

WildAnimalFactory creates wild dogs and wild tigers.

```java
public class WildAnimalFactory implements AnimalFactory {
    @Override
    public Dog createDog() {
        return new WildDog();
    }

    @Override
    public Tiger createTiger() {
        return new WildTiger();
    }
}
```

PetAnimalFactory creates pet dogs and pet tigers.

```java
public class PetAnimalFactory implements AnimalFactory {
    @Override
    public Dog createDog() {
        return new PetDog();
    }

    @Override
    public Tiger createTiger() {
        return new PetTiger();
    }
}
```

Tiger and Dog are two interfaces that are treated as abstract products.

```java
public interface Tiger {
    void speak();

    void preferredAction();
}
```

```java
public interface Dog {
    void speak();

    void preferredAction();
}
```

PetTiger, PetDog, WIldTiger and WildDog are concrete products.

```java
public class PetDog implements Dog{
    @Override
    public void speak() {
        System.out.println("Pet Dog says softly: Bow-Wow.");
    }

    @Override
    public void preferredAction() {
        System.out.println("Pet Dogs prefer to stay at home.\n");
    }
}
```

```java
public class PetTiger implements Tiger {
    @Override
    public void speak() {
        System.out.println("Pet Tiger says softly: Halum.");
    }

    @Override
    public void preferredAction() {
        System.out.println("Pet Tigers play in the animal circus.\n");
    }
}
```

```java
public class WildDog implements Dog {
    @Override
    public void speak() {
        System.out.println("Wild Dog says loudly: Bow-Wow.");
    }

    @Override
    public void preferredAction() {
        System.out.println("Wild Dogs prefer to roam freely in jungles.\n");
    }
}
```

```java
public class WildTiger implements Tiger {
    @Override
    public void speak() {
        System.out.println("Wild Tiger says loudly: Halum.");
    }

    @Override
    public void preferredAction() {
        System.out.println("Wild Tigers prefer hunting in jungles.\n");
    }
}
```

Finally, the AbstractFactoryPatternExample class.

```java
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
```

Results

```markdown
Wild Dog says loudly: Bow-Wow.
Wild Dogs prefer to roam freely in jungles.

Wild Tiger says loudly: Halum.
Wild Tigers prefer hunting in jungles.

Pet Dog says softly: Bow-Wow.
Pet Dogs prefer to stay at home.

Pet Tiger says softly: Halum.
Pet Tigers play in the animal circus.
```

##### Real World Example

javax.xml.parsers.DocumentBuilderFactory
javax.xml.transform.TransformerFactory
javax.xml.xpath.XPathFactory

##### Analysis

Any change in the abstract factory forces us to propagate the modificaation of the concrete factories.