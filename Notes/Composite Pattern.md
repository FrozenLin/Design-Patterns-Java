### Composite Pattern

##### GoF Definition

> Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.

##### Programmatic Example

We have an interface.

```java
public interface IEmployee {
    void printStructures();

    int getEmployeeCount();
}
```

And Class Employee.

```java
public class Employee implements IEmployee {
    private String name;
    private String dept;
    private int employeeCount = 0;

    public Employee(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    @Override
    public void printStructures() {
        System.out.println("\t\t" + this.name + " works in " + this.dept);
    }

    @Override
    public int getEmployeeCount() {
        return employeeCount;
    }
}
```

And the CompositeEmployee Class.

```java
import java.util.ArrayList;
import java.util.List;

public class CompositeEmployee implements IEmployee {
    private int employeeCount = 0;

    private String name;
    private String dept;

    // Container for child objects
    private List<IEmployee> controls;

    public CompositeEmployee(String name, String dept) {
        this.name = name;
        this.dept = dept;
        controls = new ArrayList<>();
    }

    public void addEmployee(IEmployee e) {
        controls.add(e);
    }

    public void removeEmployee(IEmployee e) {
        controls.remove(e);
    }

    @Override
    public void printStructures() {
        System.out.println("\t" + this.name + " works in " + this.dept);
        for (IEmployee e : controls) {
            e.printStructures();
        }
    }

    @Override
    public int getEmployeeCount() {
        employeeCount = controls.size();
        for (IEmployee e : controls) {
            employeeCount += e.getEmployeeCount();
        }
        return employeeCount;
    }
}
```

Finally, the CompositeEmployee Class. We have two math teachers in math dept and three computer science teachers in CS dept. We also have two heads for the two departments. And the principle of the college.

```java
public class CompositePatternExample {
    public static void main(String[] args) {
        // Math teachers
        Employee mathTeacher1 = new Employee("Math Teacher-1", "Maths");
        Employee mathTeacher2 = new Employee("Math Teacher-2", "Maths");

        // CS teachers
        Employee cseTeacher1 = new Employee("CSE Teacher-1", "Computer Sc.");
        Employee cseTeacher2 = new Employee("CSE Teacher-2", "Computer Sc.");
        Employee cseTeacher3 = new Employee("CSE Teacher-3", "Computer Sc.");

        // 2 heads of the two departments
        CompositeEmployee hodMaths = new CompositeEmployee("Mrs.S.Das(HOD-Maths)", "Maths");
        CompositeEmployee hodCompSc = new CompositeEmployee("Mr.S.Sarcar(HOD-CSE)", "Computer Sc.");

        // Principle of college
        CompositeEmployee principal = new CompositeEmployee("Dr.S.Som(Principal)", "Managing");

        hodMaths.addEmployee(mathTeacher1);
        hodMaths.addEmployee(mathTeacher2);

        hodCompSc.addEmployee(cseTeacher1);
        hodCompSc.addEmployee(cseTeacher2);
        hodCompSc.addEmployee(cseTeacher3);

        principal.addEmployee(hodMaths);
        principal.addEmployee(hodCompSc);

        // Test the structures
        principal.printStructures();
        System.out.println("At present Principal has control over " + principal.getEmployeeCount()
                + " number of employees.");

        hodCompSc.printStructures();
        System.out.println("At present HOD-CSE has control over " + hodCompSc.getEmployeeCount()
                + " number of employees.");
        hodMaths.printStructures();
        System.out.println("At present HOE-Maths has control over " + hodMaths.getEmployeeCount()
                + " number of employees.");

        // Leaf node
        mathTeacher1.printStructures();
        System.out.println("At present Math Teacher-1 has control over " + mathTeacher1.getEmployeeCount()
                + " number of employees.");
    }
}
```

Results

```markdown
Dr.S.Som(Principal) works in Managing
	Mrs.S.Das(HOD-Maths) works in Maths
		Math Teacher-1 works in Maths
		Math Teacher-2 works in Maths
	Mr.S.Sarcar(HOD-CSE) works in Computer Sc.
		CSE Teacher-1 works in Computer Sc.
		CSE Teacher-2 works in Computer Sc.
		CSE Teacher-3 works in Computer Sc.
At present Principal has control over 7 number of employees.
	Mr.S.Sarcar(HOD-CSE) works in Computer Sc.
		CSE Teacher-1 works in Computer Sc.
		CSE Teacher-2 works in Computer Sc.
		CSE Teacher-3 works in Computer Sc.
At present HOD-CSE has control over 3 number of employees.
	Mrs.S.Das(HOD-Maths) works in Maths
		Math Teacher-1 works in Maths
		Math Teacher-2 works in Maths
At present HOE-Maths has control over 2 number of employees.
		Math Teacher-1 works in Maths
At present Math Teacher-1 has control over 0 number of employees.
```

##### Real-World Example

java.awt.Container and java.awt.Component. The generic AWT container object is a component that can contain other AWT components.

##### Analysis

This pattern is useful to represent part-whole hierarchies of objects. 

The usage of this pattern is very common in a tree-like data structure.



