### Bridge Pattern

##### GoF Definition

> Decouple an abstraction from its implementation so that the two can vary independently.

##### Programmatic Example

The State interface plays the role of the implementor.

```java
interface State {
    void moveState();

    void hardPressed();
}
```

The ElectronicGoods abstract class plays the role of abstraction.

```java
abstract class ElectronicGoods {
    //Composition - implementor
    protected State state;

//    public ElectronicGoods(State state) {
//        this.state = state;
//    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void moveToCurrentState() {
        System.out.print("The electronic item is functioning at : ");
        state.moveState();
    }

    public void hardButtonPressed() {
        state.hardPressed();
    }
}
```

The concrete implementors are OnState class and OffState class. 

```java
public class OnState implements State {
    @Override
    public void moveState() {
        System.out.print("On State\n");
    }

    @Override
    public void hardPressed() {
        System.out.print("\tThe device is already On.Do not press the button so hard.\n");
    }
}
```

```java
public class OffState implements State {
    @Override
    public void moveState() {
        System.out.print("Off State\n");
    }

    @Override
    public void hardPressed() {
        System.out.print("\tThe device is Offline now.Do not press the off button again.\n");
    }
}
```

There are two refined abstractions: Television and DVD.

```java
class Television extends ElectronicGoods {
    // The television class do not want to modify any subclass method.
}
```

```java
class DVD extends ElectronicGoods {
    public void doublePress() {
        hardButtonPressed();
        hardButtonPressed();
    }
}
```

BridgePattern demo class

```java
public class BridgePatternDemo {
    public static void main(String[] args) {
        System.out.println("\n Dealing with a Television at present.");
        State presentState = new OnState();
        //ElectronicGoods eItem = new Television(presentState);
        ElectronicGoods eItem = new Television();
        eItem.setState(presentState);
        eItem.moveToCurrentState();
        //hard press
        eItem.hardButtonPressed();
        //Verifying Off state of the Television now
        presentState = new OffState();
        //eItem = new Television(presentState);
        eItem.setState(presentState);
        eItem.moveToCurrentState();

        System.out.println("\n Dealing with a DVD now.");
        presentState = new OnState();
        //eItem = new DVD(presentState);
        eItem = new DVD();
        eItem.setState(presentState);
        eItem.moveToCurrentState();
        presentState = new OffState();
        //eItem = new DVD(presentState);
        eItem = new DVD();
        eItem.setState(presentState);
        eItem.moveToCurrentState();
        //hard press-A DVD specific method
        //(new DVD(presentState)).doublePress();
        ((DVD) eItem).doublePress();
        // Error code because a television object does not have this method.
        //(new Television(presentState)).doublePress();
    }
}
```

Result

```markdown
Dealing with a Television at present.
The electronic item is functioning at : On State
	The device is already On.Do not press the button so hard.
The electronic item is functioning at : Off State

 Dealing with a DVD now.
The electronic item is functioning at : On State
The electronic item is functioning at : Off State
	The device is Offline now.Do not press the off button again.
	The device is Offline now.Do not press the off button again.
```

##### Real-World Example

JDBC provide a bridge between application and database.

 java.sql.DriverManager class and the java.sql.Driver interface can form a bridge pattern.

##### Analysis

Bridge Pattern also known as handle/body pattern.

- The implementations are not bound to the abstractions.

- Both the abstractions and the implementations can grow independently.

- Concrete classes are independent from the interface implementer classes 