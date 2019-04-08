package FlyweightPattern;

public class FixedSizeRobot implements Robot{
    /**
     * Intrinsic state. Immutable
     * Not supplied by client.
     * Independent of the flyweight's context.
     */
    private final String robotTypeCreated;

    public FixedSizeRobot() {
        robotTypeCreated = "A robot with a fixed size created";
        System.out.print(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.print(" with " + " blue (default) color");
    }
}
