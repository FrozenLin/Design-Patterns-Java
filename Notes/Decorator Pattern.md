### Decorator Pattern

##### GoF Definition

> Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

##### Programmatic Example

We have our makeHouse() method.

```java
abstract class AbstractDecorator extends Component {
    protected Component component;

    public void setTheComponent(Component c) {
        component = c;
    }

    public void makeHouse() {
        if (component != null) {
            //Delegating the task
            component.makeHouse();
        }
    }
}
```

```java
abstract class Component {
    public abstract void makeHouse();
}
```

```java
public class ConcreteComponent extends Component {
    public void makeHouse() {
        System.out.println("Original House is complete. It is closed for modification.");
    }
}
```

Two decorators, PaintDecorator and FloorDecorator. We kept our original structure and do not modify the makeHouse method in ConcreteComponent class.

```java
public class PaintDecorator extends AbstractDecorator {
    public void makeHouse() {
        super.makeHouse();
        //Decorating now.
        System.out.println("***Paint decorator is in action now***");
        paintTheHouse();
        //You can add additional stuffs as per your need
    }

    private void paintTheHouse() {
        System.out.println("Now I am painting the house.");
    }
}
```

```java
public class FloorDecorator extends AbstractDecorator {
    public void makeHouse() {
        super.makeHouse();
        //Decorating now.
        System.out.println("***Floor decorator is in action***");
        addFloor();
        /*You can put additional stuffs as per your need*/
    }

    private void addFloor() {
        System.out.println("I am making an additional floor on top of it.");
    }
}
```

Finally, the DecoratorPatternExample class.

```java
public class DecoratorPatternExample {
    public static void main(String[] args) {
        ConcreteComponent withoutDecorator = new ConcreteComponent();
        withoutDecorator.makeHouse();
        System.out.println("_________________");

        //Using a decorator to add floor
        System.out.println("Using a Floor decorator now.");
        FloorDecorator floorDecorator = new FloorDecorator();
        floorDecorator.setTheComponent(withoutDecorator);
        floorDecorator.makeHouse();
        System.out.println("_________________");

        //Using a decorator to add floor to original house and then paint it.
        System.out.println("Using a Paint decorator now.");
        PaintDecorator paintDecorator = new PaintDecorator();
        //Adding results from floor decorator
         paintDecorator.setTheComponent(floorDecorator);
         paintDecorator.makeHouse();
         System.out.println("_________________");
    }
}
```

Result

```
Original House is complete. It is closed for modification.
_________________
Using a Floor decorator now.
Original House is complete. It is closed for modification.
***Floor decorator is in action***
I am making an additional floor on top of it.
_________________
Using a Paint decorator now.
Original House is complete. It is closed for modification.
***Floor decorator is in action***
I am making an additional floor on top of it.
***Paint decorator is in action now***
Now I am painting the house.
_________________
```

##### Real-World Example

java.io.InputStream, java.io.OutputStream, java.io.Reader and java.io.Writer

The java. io.BufferedoutputStream class can decorate any java.io.outputStream object.

```java
BufferedOutputStream bufferedOutput = new BufferedOutputStream(new FileOutputStream(filename));
```

##### Analysis

This pattern says that the class must be closed for modification but open for extension

The enclosing object is called a decorator. It must conform to the interface of the component that it decorates. 

One of the key design principles: **Classes should be open for extension but closed for modification.**