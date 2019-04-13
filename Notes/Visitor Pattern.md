### Visitor Pattern

##### GoF Definition

> Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.

##### Programmatic Example

First, we have two interfaces.

```java
interface OriginalInterface {
    void acceptVisitor(Visitor visitor);
}
```

```java
interface Visitor {
    void visit(MyClass myClassObject);
}
```

MyClass has a value 5. Suppose we want to modify this initialized value. We have two ways. One is add a method inside this class. Another way is to use a visitor pattern.

```java
class MyClass implements OriginalInterface {
    private final int myInt;

    public MyClass() {
        myInt = 5;
    }

    public int getMyInt() {
        return myInt;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }
}
```

By using the visitor pattern, you can just update the visitor's method. You don't need to change original class.

```java
class ConcreteVisitor implements Visitor {
    @Override
    public void visit(MyClass myClassObject) {
        System.out.println("Current value of myInt=" + myClassObject.getMyInt());
        System.out.println("Visitor will make it double and display it.");
        System.out.println("Current value of myInt=" + 2 * myClassObject.getMyInt());
        System.out.println("Exiting from Visitor.");
    }
}
```

Finally, VisitorPatternExample class.

```java
class VisitorPatternExample {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        MyClass myClass = new MyClass();
        myClass.acceptVisitor(visitor);
    }
}
```

Result

```markdown
Current value of myInt=5
Visitor will make it double and display it.
Current value of myInt=10
Exiting from Visitor.
```

##### Real-World Example

org.dom4j.VisitorSupport

javax.lang.model.elemetn.Element

##### Analysis

If you need to add new operations to a set of objects without changing their corresponding classes. you can consider implementing visitor design patterns.

*Drawback with this pattern*—It will violate the encapsulation.

