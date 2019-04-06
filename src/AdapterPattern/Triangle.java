package AdapterPattern;

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
