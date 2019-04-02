package SingletonPattern;

public class SingletonPatternExample {
    public static void main(String[] args) {
        System.out.println("Trying to make a captain for your team:");
        Captain captain1 = Captain.getCaptain();
        System.out.println("Let's make another captain.");
        Captain captain2 = Captain.getCaptain();
        if (captain1 == captain2) {
            System.out.println("captain1 and captain2 are same instance.");
        }
    }
}
