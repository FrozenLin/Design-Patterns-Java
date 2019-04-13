package MediatorPattern;

public interface Mediator {
    void register(Employee employee);

    void sendMessage(Employee employee, String msg) throws InterruptedException;
}
