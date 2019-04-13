### Adapter Pattern

##### GoF Definition

> Convert the interface of a class into another interface that clinets expect. Adapter lets classes work together that could not otherwise because of incompatible interfaces.

##### Programmatic Example

Follow the ood principles, instead of using concrete classes, you should always prefer to use interfaces.

Interfaces

```java
interface TriInterface {
    void aboutTriangle();

    double calculateAreaOfTriangle();
}
```

```java
interface RectInterface {
    void aboutRectangle();

    double calculateAreaOfRectangle();
}
```

Class Triangle and Rectangle. They implement calculate method.

```java
public class Triangle implements TriInterface {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void aboutTriangle() {
        System.out.println("Triangle object with base: " + this.base
                + " unit and height: " + this.height + " unit.");
    }

    @Override
    public double calculateAreaOfTriangle() {
        return 0.5 * base * height;
    }
}
```

```java
public class Rectangle implements RectInterface {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void aboutRectangle() {
        System.out.println("Rectangle object with length: " + this.length
                + "unit and witdth: " + this.width + " unit.");
    }

    @Override
    public double calculateAreaOfRectangle() {
        return length * width;
    }
}
```

Adapter.

```java
public class TriangleAdapter implements RectInterface {
    Triangle triangle;

    public TriangleAdapter(Triangle t) {
        this.triangle = t;
    }

    @Override
    public void aboutRectangle() {
        triangle.aboutTriangle();
    }

    @Override
    public double calculateAreaOfRectangle() {
        return triangle.calculateAreaOfTriangle();
    }
}
```

Finally, the class AdapterPatternExample. The getArea() method does not know that it is processing a triangle object through the TriangleAdapter.

```java
import java.util.ArrayList;
import java.util.List;

public class AdapterPatternExample {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(20, 10);
        System.out.println("Area of Rectangle is: " + rectangle.calculateAreaOfRectangle() + " Square unit.");

        Triangle triangle = new Triangle(10, 5);
        System.out.println("Area of Triangle is: " + triangle.calculateAreaOfTriangle() + " Square unit.");

        RectInterface adapter = new TriangleAdapter(triangle);
        // Passing a Triangle instead of a Rectangle
        System.out.println("Area of Triangle using the triangle adapter is: " + getArea(adapter) + " Square unit.");

        // Optional code to show the power of adapter pattern
        List<RectInterface> rectangleObjects = new ArrayList<>();
        rectangleObjects.add(rectangle);
//        rectangleObjects.add(Triangle); // error
        rectangleObjects.add(adapter);
        System.out.println("Current object in the systems:");
        for (RectInterface rectObjects : rectangleObjects) {
            rectObjects.aboutRectangle();
        }
    }

    static double getArea(RectInterface r) {
        return r.calculateAreaOfRectangle();
    }
}
```

Results

```markdown
Area of Rectangle is: 200.0 Square unit.
Area of Triangle is: 25.0 Square unit.
Area of Triangle using the triangle adapter is: 25.0 Square unit.
Current object in the systems:
Rectangle object with length: 20.0unit and witdth: 10.0 unit.
Triangle object with base: 10.0 unit and height: 5.0 unit.
```

##### Real-World Example

java.io.InputStreamReader

java.io.OutputStreamWriter

These two classes are examples of object adapters. They adapt an existing InputStream/OutputStream object to a Reader/Writer interface.

##### Analysis

There are two types of adapters.  Object adapters and class adapters.

> *Object Adapters* adapt through object compositions.
>
> *Class Adapters* adapt through subclassing.

To create an object adapter, follow these rules.

- Your class needs to implement the target inteface (**adapting to** interface)
- Mention the class that you are **adapting from** in the constructor and store a reference to it in an instance variable.
- Override the interface methods to delegate the corresponding methods of hte class you are adapting from.