### Prototype Pattern

##### GoF Definition

> Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.

##### Programmatic Example

BasicCar is a basic prototype.

```java
import java.util.Random;

public abstract class BasicCar implements Cloneable {
    public String modelName;
    public int basePrice, onRoadPrice;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public static int setAdditionalPrice() {
        int price = 0;
        Random r = new Random();
        int p = r.nextInt(100000);
        price = p;
        return price;
    }

    public BasicCar clone() throws CloneNotSupportedException {
        return (BasicCar) super.clone();
    }
}
```

Nano and Ford are the concrete prototypes that have implemented the clone() method in BasicCar.

```java
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
```

```java
public class Ford extends BasicCar {
    // base price
    public int basePrice = 100000;

    public Ford(String m) {
        modelName = m;
    }

    @Override
    public BasicCar clone() throws CloneNotSupportedException {
        return (Ford) super.clone();
    }
}
```

PrototypePatternExample is the client in this implementation.

```java
public class PrototypePatternExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        BasicCar nano = new Nano("Green Nano");
        nano.basePrice = 100000;

        BasicCar ford = new Ford("Ford Yellow");
        ford.basePrice = 500000;

        // Nano
        BasicCar bc1;
        bc1 = nano.clone();
        bc1.onRoadPrice = nano.basePrice + BasicCar.setAdditionalPrice();
        System.out.println("Car is: " + bc1.modelName + " and it's price is " + bc1.onRoadPrice);

        // Ford
        bc1 = ford.clone();
        bc1.onRoadPrice = ford.basePrice + BasicCar.setAdditionalPrice();
        System.out.println("Car is: " + bc1.modelName + " and it's price is " + bc1.onRoadPrice);
    }
}
```

Result

```markdown
Car is: Green Nano and it's price is 125567
Car is: Ford Yellow and it's price is 567887
```

##### Real World Example

Object.clone() method as an example of prototype.

##### Shallow Copy & Deep Copy

A shallow copy creates a new object and then copies various field values from original object to the new object. It also known as a field-by-field copy.

clone() method performs a shallow copy.

In a deep copy, the new object is separated from the original one. Any changes made in one object should not be reflected on the other one.

To create a deep copy in Java, you may need to override the clone() method and then proceed.

```markdown
Example
X1 -> Y1 -> Z1   shallow copy: X2 -> Y1  deep copy: X3 -> Y3 -> Z3 
(Y3, Z3 are actual copies of Y1)
```

Shallow copy is faster and less expensive. It is always better if your object has only the primitive fields.

Deep copy is expensive and slow. It is useful if your object contains many fields that have references to other objects.

