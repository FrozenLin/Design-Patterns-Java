### Memento Pattern

##### GoF Definition

> Without violating encapsulation, capture and externalize an object’s internal state so that the object can be restored to this state later.

##### Programmatic Example

Memento class

```java
class Memento {
    private int stateId;

    public Memento(int stateId) {
        this.stateId = stateId;
    }

    public int getStateId() {
        return stateId;
    }

    /*This class does not have the
    setter method.We need to use this class
    to get the state of the object only.*/
    /*public void setState(String state) {
        this.state = state;
    }*/
}
```

Originator class

```java
class Originator {
    private int stateId;

    public Originator() {
        this.stateId = 0;
        System.out.println(" Originator is created with state id : " + stateId);
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        System.out.println(" Setting the state id of the originator to : " + stateId);
        this.stateId = stateId;
    }

    //Saving its internal state to a(memento) object
    public Memento saveMemento(int stateId) {
        System.out.println(" Saving originator's current state id. "); //Create memento with the current state and return it.
        return new Memento(stateId);
    }

    //Restoring to a previous state from a(memento) object.
    public void revertMemento(Memento previousMemento) {
        System.out.println(" Restoring to state id..." + previousMemento.getStateId());
        this.stateId = previousMemento.getStateId();
        System.out.println(" Current state id of originator : " + stateId);
    }
}
```

Result

```markdown
Originator is created with state id : 0
 Setting the state id of the originator to : 1
 Saving originator's current state id. 
 Snapshot #1: Originator's current state id is saved in caretaker.
 Setting the state id of the originator to : 2
 Saving originator's current state id. 
 Snapshot #2: Originator's current state id is saved in caretaker.
 Setting the state id of the originator to : 3
 Restoring to state id...2
 Current state id of originator : 2
```

##### Real-World Example

java.util.Date

##### Analysis

Using this pattern, you can restore an object to its previous state.

Once the memento instance is created by an originator, no one else besides its creator is allowed to access the internal state.

A caretaker’s job is to store the memento instance and supply them back when you are in need.