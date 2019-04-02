package SingletonPattern;

final class Captain {
    private static Captain captain;

    private Captain() {}

    public static synchronized Captain getCaptain() {
        // lazy initialization: create an object only when it is required.
        if (captain == null) {
            captain = new Captain();
            System.out.println("New captain is elected for your team.");
        } else {
            System.out.println("You already have a captain.");
        }
        return captain;
    }
}
