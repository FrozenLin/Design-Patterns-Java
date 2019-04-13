### Facade Pattern

##### GoF Definition

> Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher- level interface that makes the subsystem easier to use.

##### Programmatic Example

In RobotFacade class, you have methods to create or destroy robots. This class takes full responsibility in creating or destroying robots. 

```java
public class RobotFacade {
    RobotColor rColor;
    RobotHands rHands;
    RobotBody rBody;

    public RobotFacade() {
        rColor = new RobotColor();
        rHands = new RobotHands();
        rBody = new RobotBody();
    }

    public void constructMilanoRobot() {
        RobotBody.createRobot();
        System.out.println("Creation of a Milano Robot Start");
        rColor.setDefaultColor();
        rHands.setMilanoHands();
        rBody.createHands();
        rBody.createRemainingParts();
        System.out.println("Milano Robot Creation End.");
        System.out.println();
    }

    public void constructRobonautRobot() {
        RobotBody.createRobot();
        System.out.println("Initiating the creational process of a Robonaut Robot.");
        rColor.setGreenColor();
        rHands.setRobonautHands();
        rBody.createHands();
        rBody.createRemainingParts();
        System.out.println("A Robonaut Robot is created.");
        System.out.println();
    }

    public void destroyMilanoRobot() {
        RobotBody.destroyRobot();
        System.out.println("Milano Robot's destruction process is started.");
        rHands.resetMilanoHands();
        rBody.destroyHands();
        rBody.destroyRemainingParts();
        System.out.println("Milano Robot's destruction process is over.");
        System.out.println();
    }

    public void destroyRobonautRobot() {
        RobotBody.destroyRobot();
        System.out.println("Initiating a Robonaut Robot's destruction process.");
        rHands.resetRobonautHands();
        rBody.destroyHands();
        rBody.destroyRemainingParts();
        System.out.println("A Robonaut Robot is destroyed.");
        System.out.println();
    }
}
```

 This facade, RobotFacade, will talk to each of the subsystems to meet the client's request.  The subsystems contains class RobotHands, RobotBody, RobotColor. The client doesn't need to worry the sequence of creating or destroying a robot. As you can see in the class RobotBody, createRobot() and destroyHands() methods are static. They provide instructions prior to the creation or destruction of a robot.

```java
public class RobotBody {
    public static void createRobot() {
        System.out.println("Refer the manual before creation of a robot.");
    }

    public void createHands() {
        System.out.println("Hands manufactured.");
    }

    public void createRemainingParts() {
        System.out.println("Remaining parts (other than hands) are created.");
    }

    public static void destroyRobot() {
        System.out.println("Refer the manual before destroying of a robot.");
    }

    public void destroyHands() {
        System.out.println("The robot's hands are destroyed.");
    }

    public void destroyRemainingParts() {
        System.out.println("The robot's remaining parts are destroyed.");
    }
}
```

```java
public class RobotColor {
    public void setDefaultColor() {
        System.out.println("This is steel color robot.");
    }

    public void setGreenColor() {
        System.out.println("This is a green color robot.");
    }
}
```

```java
public class RobotHands {
    public void setMilanoHands() {
        System.out.println("The robot will have EH1 Milano hands.");
    }

    public void setRobonautHands() {
        System.out.println("The robot will have Robonaut hands.");
    }

    public void resetMilanoHands() {
        System.out.println("EH1 Milano hands are about to to be destroyed.");
    }

    public void resetRobonautHands() {
        System.out.println("Robonaut hands are about to be destroyed.");
    }
}
```

Results

```markdown
Refer the manual before creation of a robot.
Creation of a Milano Robot Start
This is steel color robot.
The robot will have EH1 Milano hands.
Hands manufactured.
Remaining parts (other than hands) are created.
Milano Robot Creation End.

Refer the manual before creation of a robot.
Initiating the creational process of a Robonaut Robot.
This is a green color robot.
The robot will have Robonaut hands.
Hands manufactured.
Remaining parts (other than hands) are created.
A Robonaut Robot is created.

Refer the manual before destroying of a robot.
Milano Robot's destruction process is started.
EH1 Milano hands are about to to be destroyed.
The robot's hands are destroyed.
The robot's remaining parts are destroyed.
Milano Robot's destruction process is over.

Refer the manual before destroying of a robot.
Initiating a Robonaut Robot's destruction process.
Robonaut hands are about to be destroyed.
The robot's hands are destroyed.
The robot's remaining parts are destroyed.
A Robonaut Robot is destroyed.
```

##### Real-World Example

openStream() and getContent() methods in java.net.URL.class

##### Analysis

Facade pattern is very useful when you want to manage many subsystems.