package ObserverPattern;

public class ObserverPatternExample {
    public static void main(String[] args) {
        Observer myObserver1 = new ObserverType1("Roy");
        Observer myObserver2 = new ObserverType1("Kevin");
        Observer myObserver3 = new ObserverType2("Bose");
        Subject subject = new Subject();

        // Register
        subject.register(myObserver1);
        subject.register(myObserver2);
        subject.register(myObserver3);
        System.out.println("Setting Flag = 5");
        subject.setFlag(5);

        // Unregister
        subject.unregister(myObserver1);
        // No notification this time. Since it is unregistered.
        System.out.println("\n Setting Flag = 50");
        subject.setFlag(50);
        // Register Roy
        subject.register(myObserver1);
        System.out.println("\n Setting Flas = 100");
        subject.setFlag(100);
    }
}
