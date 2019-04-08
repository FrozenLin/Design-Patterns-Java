package FlyweightPattern;

public class LargeRobot implements Robot {
    /**
     * Intrinsic state. Immutable
     * Not supplied by client.
     * Independent of the flyweight's context.
     */
    private final String robotTypeCreated;

    public LargeRobot() {
        robotTypeCreated = "A large robot created";
        System.out.print(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.print(" with " + color + " color ");
    }
}
