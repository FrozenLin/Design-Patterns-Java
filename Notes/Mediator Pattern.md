### Mediator Pattern

##### GoF Definition

> Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently.

##### Programmatic Example

Mediator is an interface that has two methods.

```java
public interface Mediator {
    void register(Employee employee);

    void sendMessage(Employee employee, String msg) throws InterruptedException;
}
```

ConcreteMediator maintains the list of  Employee objects. It implements the Mediator interface and coordinates the communication among the Employee objects.

```java
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    List<Employee> participants = new ArrayList<Employee>();

    @Override
    public void register(Employee employee) {
        participants.add(employee);
    }

    public void displayRegisteredEmployees() {
        System.out.println("At present,registered employees are:");
        for (Employee employee : participants) {
            System.out.println(employee.getName());
        }
    }

    @Override
    public void sendMessage(Employee employee, String msg) throws InterruptedException {
        if (participants.contains(employee)) {
            System.out.println(employee.getName() + " posts:" + msg + "Last message posted at " + LocalDateTime.now());
            Thread.sleep(1000);
        } else {
            System.out.println("An outsider named " + employee.getName() + " is trying to send some messages.");
        }
    }
}
```

We have an abstract Employee class defines the interface for communication with other Employees.

```java
abstract class Employee {
    protected Mediator mediator;
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Constructor
    public Employee(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String msg) throws InterruptedException {
        mediator.sendMessage(this, msg);
    }

    public abstract String employeeType();
}
```

We have three types of emplyee.

```java
public class JuniorEmployee extends Employee {
    public JuniorEmployee(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    @Override
    public String employeeType() {
        return "JuniorEmployee";
    }
}
```

```java
public class SeniorEmployee extends Employee {
    public SeniorEmployee(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    @Override
    public String employeeType() {
        return "SeniorEmployee";
    }
}
```

```java
public class Unknown extends Employee {
    public Unknown(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    @Override
    public String employeeType() {
        return "Outsider";
    }
}
```

class MediatorPatternExample.

```java
public class MediatorPatternExample {
    public static void main(String[] args) throws InterruptedException {
        ConcreteMediator mediator = new ConcreteMediator();
        JuniorEmployee amit = new JuniorEmployee(mediator, "Amit");
        JuniorEmployee sohel = new JuniorEmployee(mediator, "Sohel");
        SeniorEmployee raghu = new SeniorEmployee(mediator, "Raghu");
        //Registering participants
        mediator.register(amit);
        mediator.register(sohel);
        mediator.register(raghu);
        //Displaying the participant's list
        mediator.displayRegisteredEmployees();
        System.out.println("Communication starts among participants...");
        amit.sendMessage("Hi Sohel,can we discuss the mediator pattern?");
        sohel.sendMessage("Hi Amit,yup, we can discuss now.");
        raghu.sendMessage("Please get back to work quickly.");
        //An outsider/unknown person tries to participate
        Unknown unknown = new Unknown(mediator, "Jack");
        unknown.sendMessage("Hello Guys..");
    }
}
```

Results

```markdown
At present,registered employees are:
Amit
Sohel
Raghu
Communication starts among participants...
Amit posts:Hi Sohel,can we discuss the mediator pattern?Last message posted at 2019-04-13T15:04:28.777
Sohel posts:Hi Amit,yup, we can discuss now.Last message posted at 2019-04-13T15:04:29.860
Raghu posts:Please get back to work quickly.Last message posted at 2019-04-13T15:04:30.866
An outsider named Jack is trying to send some messages.
```

##### Real-World Example

execute() method in java.util.concurrent.Executor interface.

various schedule() methods of the java.util.Timer class.

##### Analysis

This pattern can promotes loose coupling and reduces number of subclasses in the system. It can also reduce the complexity of objects' cmmunication in a system.

However, maintaining the mediator is a big concern and the mediator object's architecture may become complex.