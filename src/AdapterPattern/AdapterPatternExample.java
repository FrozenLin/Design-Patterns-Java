package AdapterPattern;

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
