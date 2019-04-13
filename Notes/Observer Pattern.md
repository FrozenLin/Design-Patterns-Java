### Observer Pattern

##### GoF Definition

> Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

##### Programmatic Example

We have Observer interface which has the update method.

```java
interface Observer {
    void update(int updatedValue);
}
```

Class ObserverType1 and ObserverType2 implement update method in the Observer interface. Observer will receive notification when the flag value has changed.

```java
class ObserverType1 implements Observer{
    String nameOfObserver;

    public ObserverType1(String name) {
        this.nameOfObserver = name;
    }

    @Override
    public void update(int updatedValue) {
        System.out.println(nameOfObserver + " has received an alert:" +
                "Updated myValue in Subject is:" + updatedValue);
    }
}
```

```java
class ObserverType2 implements Observer{
    String nameOfObserver;

    public ObserverType2(String name) {
        this.nameOfObserver = name;
    }

    @Override
    public void update(int updatedValue) {
        System.out.println(nameOfObserver + " has received an alert: " +
                "The current value of myValue in Subject is: " + updatedValue);
    }
}
```

SubjectInterface defines three methods. 

```java
interface SubjectInterface {
    void register(Observer anObserver);

    void unregister(Observer anObserver);

    void notifyRegisteredUsers(int notifiedValue);
}
```

```java
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
```

ObserverPatternExample shows that when observer is registered, updating the flag value can get a notification. If the observer object, Roy is unregistered. Then we cannot get the notification when changing the flag value.

```java
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
```

Results

```markdown
Setting Flag = 5
Roy has received an alert:Updated myValue in Subject is:5
Kevin has received an alert:Updated myValue in Subject is:5
Bose has received an alert: The current value of myValue in Subject is: 5

 Setting Flag = 50
Kevin has received an alert:Updated myValue in Subject is:50
Bose has received an alert: The current value of myValue in Subject is: 50

 Setting Flas = 100
Kevin has received an alert:Updated myValue in Subject is:100
Bose has received an alert: The current value of myValue in Subject is: 100
Roy has received an alert:Updated myValue in Subject is:100
```

##### Real-World Example

java.util.EventListener

##### Analysis

There are some benifits using this pattern.

- The subject and its registered users(observers) are making a loosely coupled system.

- No modification is required in subjects when you add or remove an observer from its notification lists.

- Add or remove observers at any time.