### Strategy (Policy) Pattern

##### GoF Definition

> Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.

##### Programmatic Example

Interface

```java
public interface TransportMedium {
    public void transport();
}
```

Context class

```java
public abstract class Vehicle {
    TransportMedium transportMedium;

    public Vehicle() {
    }

    public void showTransportMedium() {
        transportMedium.transport();
    }

    public void commonJob() {
        System.out.println("We all can be used to transport");
    }

    public abstract void showMe();
}
```

Two implementations of the Vehicle class, boat and aeroplane.

```java
public class Boat extends Vehicle {
    public Boat() {
        transportMedium = new WaterTransport();
    }

    @Override
    public void showMe() {
        System.out.println("I am a boat.");
    }

}
```

```java
public class Aeroplane extends Vehicle {
    public Aeroplane() {
        transportMedium = new AirTransport();
    }

    @Override
    public void showMe() {
        System.out.println("I am an aeroplane.");
    }
}
```

Two algorithms/behaviors.

```java
public class WaterTransport implements TransportMedium {
    @Override
    public void transport() {
        System.out.println("I am transporting in water.");
    }
}
```

```java
public class AirTransport implements TransportMedium {
    @Override
    public void transport() {
        System.out.println("I am transporting in air.");
    }
}
```

Class StrategyPatternExample

```java
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
```

Results

```markdown
I am a boat.
I am transporting in water.
I am an aeroplane.
I am transporting in air.
```

##### Real-World Example

java.util.Comparator interface. It plays the role of a strategy interface in this context.

##### Analysis

Suppose you have an application and many algorithms and each of them can perform a specific task. 

The strategy pattern suggests that you implement these algorithms in separate classes. When you encapsulate an algorithm in a separate class, you call it a *strategy*. An object that uses the strategy object is often referred to as a *context* object.