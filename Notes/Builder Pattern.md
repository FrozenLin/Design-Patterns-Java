### Builder Pattern

##### GOF Definition

> Separate the construction of a complex object from its representation so that the same construction processes can create different representations.

##### Programmatic Example

We have Builder, Car, Motorcycle, Product and Director.

Builder is used to create parts of the Product object.

```java
public interface Builder {
    void startUpOperations();

    void buildBody();

    void insertWheels();

    void addHeadlights();

    void endOperations();

    // The following method is used to retrieve the object that is constructed.
    Product getVehicle();
}
```

Car and motorcycle are concrete implementations of the Builder interface.

```java
public class Car implements Builder {
    private String brandName;
    private Product product;

    public Car(String brand) {
        product = new Product();
        this.brandName = brand;
    }

    public void startUpOperations() {
        product.add(String.format("Car model is :%s", this.brandName));
    }

    public void buildBody() {
        product.add("This is the body of a Car");
    }

    public void insertWheels() {
        product.add("4 Wheels are added");
    }

    public void addHeadlights() {
        product.add("2 Headlights are added");
    }

    public void endOperations() {
    }

    public Product getVehicle() {
        return product;
    }
}
```

```java
public class MotorCycle implements Builder {
    private String brandName;
    private Product product;

    public MotorCycle(String brand) {
        product = new Product();
        this.brandName = brand;
    }

    public void startUpOperations() {

    }

    public void buildBody() {
        product.add("This is a body of a Motorcycle");
    }

    public void insertWheels() {
        product.add("2 wheels are added");
    }

    public void addHeadlights() {
        product.add("1 headlight is added");
    }

    public void endOperations() {
        product.add(String.format("Motorcycle model is: %s", this.brandName));
    }

    public Product getVehicle() {
        return product;
    }
}
```

Director is responsible for constructing the final representation of these products using the Builder interface.

```java
public class Director {
    Builder builder;

    // Director knows how to use the builder and the sequence of steps.
    public void construct(Builder builder) {
        this.builder = builder;
        builder.startUpOperations();
        builder.buildBody();
        builder.insertWheels();
        builder.addHeadlights();
        builder.endOperations();
    }
}
```

Finally, the builder pattern class.

```java
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
```

Results

```markdown
Product completed as below: 
Car model is :Ford
This is the body of a Car
4 Wheels are added
2 Headlights are added

 Product completed as below: 
This is a body of a Motorcycle
2 wheels are added
1 headlight is added
Motorcycle model is: Honda
```

##### Real World Example

Java.util.Calendar.Builder class (Java 8)

The builder pattern can be used when we want to convert one text format to another text format (e.g., RTF to ASCII text).

##### When to use

If you need to make a complex object that involves various steps in the construction process, and at the same time, the products need to be immutable, the builder pattern is a good choice.