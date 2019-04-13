### Flyweight Pattern

##### GoF Definition

> Use sharing to support large numbers of fine-grained objects efficiently.

##### Concept

> A flyweight is a shared object that can be used in multiple contexts simulta- neously. The flyweight acts as an independent object in each context—it’s indistinguishable from an instance of the object that’s not shared. Flyweights cannot make assumptions about the context in which they operate.

##### Programmatic Example

First, we have an interface Robot.

```java
interface Robot {
    // Color comes from client. It is extrinsic
    void showMe(String color);
}
```

We have three different types of objects: small, larget and fixed-size robots. These robots have two states, robotTypeCreated and color. The first one can be shared among similar objects. It is intrinsic state. The second one is provided by client and it is varied with the context. So, it is extrinsic stae.

```java
public class SmallRobot implements Robot {
    /**
     * Intrinsic state. Immutable
     * Not supplied by client.
     * Independent of the flyweight's context.
     */
    private final String robotTypeCreated;

    public SmallRobot() {
        robotTypeCreated = "A small robot created";
        System.out.print(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.print(" with " + color + " color ");
    }
}
```

```java
public class LargeRobot implements Robot {
    /**
     * Intrinsic state. Immutable
     * Not supplied by client.
     * Independent of the flyweight's context.
     */
    private final String robotTypeCreated;

    public LargeRobot() {
        robotTypeCreated = "A large robot created";
        System.out.print(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.print(" with " + color + " color ");
    }
}
```

```java
public class FixedSizeRobot implements Robot{
    /**
     * Intrinsic state. Immutable
     * Not supplied by client.
     * Independent of the flyweight's context.
     */
    private final String robotTypeCreated;

    public FixedSizeRobot() {
        robotTypeCreated = "A robot with a fixed size created";
        System.out.print(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.print(" with " + " blue (default) color");
    }
}
```

RobotFactory caches flyweights and provides a method to get them.

```java
import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
    static Map<String, Robot> robotFactory = new HashMap<String, Robot>();

    public int totalObjectsCreated() {
        return robotFactory.size();
    }

    public static synchronized Robot getRobotFromFactory(String robotType) throws Exception {
        Robot robotCategory = robotFactory.get(robotType);
        if (robotCategory == null) {
            switch (robotType) {
                case "small":
                    System.out.println("We do not have Small Robot at present. So we are creating a small robot now.");
                    robotCategory = new SmallRobot();
                    break;
                case "large":
                    System.out.println("We do not have Large Robot at present. So we are creating a large robot now.");
                    robotCategory = new LargeRobot();
                    break;
                case "fixed":
                    System.out.println("We do not have fixed size at present. So we are creating a fixed size robot now.");
                    robotCategory = new FixedSizeRobot();
                    break;
                default:
                    throw new Exception(" Robot Factory can create only small, large or fixed size robots");
            }
            robotFactory.put(robotType, robotCategory);
        } else {
            System.out.print("\n \t Using existing "+ robotType +" robot and coloring it" );
        }
        return robotCategory;
    }

}
```

The FlyweightPatternExample class.

```java
import java.util.Random;

public class FlyweightPatternExample {
    public static void main(String[] args) throws Exception {
        RobotFactory robotFactory = new RobotFactory();
        System.out.println("\n***Flyweight Pattern Example ***\n");
        Robot myRobot;
        // Here we are trying to get 3 Small type robots
        for (int i = 0; i < 3; i++) {
            myRobot = RobotFactory.getRobotFromFactory("small");
            // Not required to add sleep().
            // But it can increase the probability of getting a new random number to see the variations in the output.
            Thread.sleep(1000);
            //The extrinsic property color is supplied by the client code.
            myRobot.showMe(getRandomColor());
        }
        int numOfDistinctRobots = robotFactory.totalObjectsCreated();
        System.out.println("\n Till now, total no of distinct robot objects created: " + numOfDistinctRobots);

        //Here we are trying to get 5 Large type robots
        for (int i = 0; i < 5; i++) {
            myRobot = RobotFactory.getRobotFromFactory("large");
            Thread.sleep(1000);
            myRobot.showMe(getRandomColor());
        }
        numOfDistinctRobots = robotFactory.totalObjectsCreated();
        System.out.println("\n Till now, total no of distinct robot objects created: " + numOfDistinctRobots);

        //Here we are trying to get 4 fixed sizerobots
        for (int i = 0; i < 4; i++) {
            myRobot = RobotFactory.getRobotFromFactory("fixed");
            Thread.sleep(1000);
            myRobot.showMe(getRandomColor());
        }
        numOfDistinctRobots = robotFactory.totalObjectsCreated();
        System.out.println("\n Till now, total no of distinct robot objects created: " + numOfDistinctRobots);
    }

    static String getRandomColor() {
        Random r = new Random();
        int random = r.nextInt();
        if (random % 2 == 0) {
            return "red";
        } else {
            return "green";
        }
    }
}
```

Results

It is random.

##### Real-World Example

When you use wrapper classes, such as java.lang.Integer, java.lang.Short, java.lang.Byte and java.lang.Character, where the static method valueOf() replicates a factory method. But java.lang.Double and java.lang.Float do not follow this pattern.

##### Analysis

- The pattern is useful when you need a large number of similar objects that are unique in terms of only a few parameters and most of the stuffs are common in general.
- A flyweight is an object. It tries to minimize memory usage by sharing data as much as possible with other similar objects.
- An intrinsic state is stored/shared in the flyweight object, and it is independent of flyweight’s context.
- An extrinsic state varies with flyweight’s context, which is why they cannot be shared. Client objects maintain the extrinsic state, and they need to pass this to a flyweight.
- Make intrinsic states immutable.

