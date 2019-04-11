package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject implements SubjectInterface {
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
        // Flag value has changed. Notify registered users/observers.
        notifyRegisteredUsers(flag);
    }

    List<Observer> observerList = new ArrayList<>();

    @Override
    public void register(Observer anObserver) {
        observerList.add(anObserver);
    }

    @Override
    public void unregister(Observer anObserver) {
        observerList.remove(anObserver);
    }

    @Override
    public void notifyRegisteredUsers(int updatedValue) {
        for (Observer observer : observerList) {
            observer.update(updatedValue);
        }
    }
}
