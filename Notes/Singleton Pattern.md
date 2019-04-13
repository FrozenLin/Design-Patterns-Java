### Singleton Pattern

##### GOF Definition

> Ensure a class only has one instance, and provide a global point of access to it.

##### Programmatic Example

We have a captain class.

```java
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
```

Run the demo. 

```java
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
```

Result

```markdown
Trying to make a captain for your team:
New captain is elected for your team.
Let's make another captain.
You already have a captain.
captain1 and captain2 are same instance.
```

##### Real World Example

getRuntime() method of the java.lang.Runtime class

##### When to use

- Centralized management system
- Common log file
- Maintain thread pools in a multithreaded environment

