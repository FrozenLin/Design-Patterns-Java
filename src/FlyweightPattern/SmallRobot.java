package FlyweightPattern;

public class SmallRobot implements Robot {
    /**
     * Intrinsic state. Immutable
     * Not supplied by client.
     * Independent of the flyweight's context.
     */
    private final String robotTypeCreated;

    public SmallRobot() {
        robotTypeCreated = "A small robot created";
        System.out.print(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.print(" with " + color + " color ");
    }
}
