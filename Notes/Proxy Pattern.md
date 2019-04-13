### Proxy Pattern

##### GoF Definition

> Provide a surrogate or placeholder for another object to control access to it.

##### Programmatic Example

Subject class.

```java
abstract class Subject {
    public abstract void doSomeWork();
}
```

ConcreteSubject class also have a doSomeWork() method.

```java
public class ConcreteSubject extends Subject {
    @Override
    public void doSomeWork() {
        System.out.println("doSomeWork() inside ConcreteSubject is invoked.");
    }
}
```

doSomeWork() method of the Proxy class.

```java
public class Proxy extends Subject {
    static Subject cs;

    @Override
    public void doSomeWork() {
        System.out.println("Proxy call happening now...");
        // Lazy initialization: We'll not instantiate until the method is called
        if (cs == null) {
            cs = new ConcreteSubject();
        }
        cs.doSomeWork();
    }
}
```

Finally, the ProxyPatternExample class.

```java
/**
 * The client is talking to a ConcreteSubject instance through a proxy method.
 */
public class ProxyPatternExample {
    public static void main(String[] args) {
        Proxy px = new Proxy();
        px.doSomeWork();
    }
}
```

Result

```markdown
Proxy call happening now...
doSomeWork() inside ConcreteSubject is invoked.
```

From the output, the clients do not know that the proxy object does the trick.

##### Real World Example

java.lang.reflect package, you can have a Proxy class and an InvocationHandler interface that supports a similar concept.

##### Analysis

Create multiple instances of a complex object is costly. So, you can create mutiple proxy objects that point to the original object. This mechanism can also help save system or application memory.

##### Common Types of Proxies

- Remote proxies. Hide the actual object that stays in a different address space.
- Virtual proxies. Perform optimization techniques, such as the creation of a heavy object on a demand basis. This can avoid multiple loadings of an extremely large image.
- Protection proxies. Deal with different access rights. The security team can implement a protection proxy to block Internet access to specific websites.
- Smart Reference. Performs additional housekeeping work when an object is accessed by a client.