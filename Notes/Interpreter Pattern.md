### Interpreter Pattern

##### GoF Definition

> Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.

##### Programmatic Example

Employee interface and IndividualEmployee implements this interface.

```java
interface Employee {
    public boolean interpret(Context context);
}
```

```java
public class IndividualEmployee implements Employee {
    private int yearOfExperience;
    private String currentGrade;

    public IndividualEmployee(int experience, String grade) {
        this.yearOfExperience = experience;
        this.currentGrade = grade;
    }

    @Override
    public boolean interpret(Context context) {
        if (this.yearOfExperience >= context.getYearofExperience() && context.
                getPermissibleGrades().contains(this.currentGrade)) {
            return true;
        }
        return false;
    }

}
```

Three types of expression.

```java
public class AndExpression implements Employee {
    private Employee emp1;
    private Employee emp2;

    public AndExpression(Employee emp1, Employee emp2) {
        this.emp1 = emp1;
        this.emp2 = emp2;
    }

    @Override
    public boolean interpret(Context context) {
        return emp1.interpret(context) && emp2.interpret(context);
    }
}
```

```java
public class OrExpression implements Employee {
    private Employee emp1;
    private Employee emp2;

    public OrExpression(Employee emp1, Employee emp2) {
        this.emp1 = emp1;
        this.emp2 = emp2;
    }

    @Override
    public boolean interpret(Context context) {
        return emp1.interpret(context) || emp2.interpret(context);
    }
}
```

```java
public class NotExpression implements Employee {
    private Employee emp;

    public NotExpression(Employee expr) {
        this.emp = expr;
    }

    @Override
    public boolean interpret(Context context) {
        return !emp.interpret(context);
    }
}
```

EmployeeBuilder has a buildExpression method.

```java
public class EmployeeBuilder {
    public Employee buildExpression(Employee emp1, String operator, Employee emp2) {
        //Whatever the input,converting it to lowarcase
        switch (operator.toLowerCase()) {
            case "or":
                return new OrExpression(emp1, emp2);
            case "and":
                return new AndExpression(emp1, emp2);
            case "not":
                return new NotExpression(emp1);
            default:
                System.out.println("Only AND,OR and NOT operators are allowed at present");
                return null;
        }
    }
}
```

Context class.

```java
import java.util.ArrayList;
import java.util.List;

public class Context {
    private int yearofExperience;
    private List<String> permissibleGrades;

    public Context(int experience, String... allowedGrades) {
        this.yearofExperience = experience;
        this.permissibleGrades = new ArrayList<>();
        for (String grade : allowedGrades) {
            permissibleGrades.add(grade);
        }
    }

    public int getYearofExperience() {
        return yearofExperience;
    }

    public List<String> getPermissibleGrades() {
        return permissibleGrades;
    }
}
```

InterpreterPatternExample class.

```java
public class InterpreterPatternExample {
    public static void main(String[] args) {
        //Minimum Criteria for promoton is:
        //The year of experience is minimum 10 yrs. and
        //Employee grade should be either G2 or G3
        Context context = new Context(10, "G2", "G3");
        //Different employees with grades
        Employee emp1 = new IndividualEmployee(5, "G1");
        Employee emp2 = new IndividualEmployee(10, "G2");
        Employee emp3 = new IndividualEmployee(15, "G3");
        Employee emp4 = new IndividualEmployee(20, "G4");
        EmployeeBuilder builder = new EmployeeBuilder();

        System.out.println("emp1 is eligible for promotion. " + emp1.interpret(context));
        System.out.println("emp2 is eligible for promotion. " + emp2.interpret(context));
        System.out.println("emp3 is eligible for promotion. " + emp3.interpret(context));
        System.out.println("emp4 is eligible for promotion. " + emp4.interpret(context));
        System.out.println("Is either emp1 or emp3 is eligible for promotion ? " + builder.buildExpression(emp1, "Or", emp3).interpret(context));
        System.out.println("Is both emp2 and emp4 are eligible for promotion? ?" + builder.buildExpression(emp2, "And", emp4).interpret(context));
        System.out.println("The statement 'emp3 is NOT eligible for promotion' is true? " + builder.buildExpression(emp3, "Not", null).interpret(context));
        //Invalid input expression
        //System.out.println("Is either emp1 or emp3 is eligible for promotion?" +builder.buildExpression(emp1,"Wrong",emp3). interpret(context));
    }
}
```

Result

```markdown
emp1 is eligible for promotion. false
emp2 is eligible for promotion. true
emp3 is eligible for promotion. true
emp4 is eligible for promotion. false
Is either emp1 or emp3 is eligible for promotion ? true
Is both emp2 and emp4 are eligible for promotion? ?false
The statement 'emp3 is NOT eligible for promotion' is true? false
```

##### Real-World Example

java.util.regex.Pattern class

##### Analysis

There are some steps to implement this pattern.

- Define the rules of the language for which you want to build an interpreter.
- Define an abstract class or an interface to represent an expression. It should contain a method to interpret an expression.
- Identify terminal and nonterminal expressions. 
- Create nonterminal expression classes. Each of them calls interpret method on their children.
- Build the abstract syntax tree using these classes. You can do this inside the client code or you can create a separate class to accomplish the task.
- A client now uses this tree to interpret a sentence.
- Pass the context to the interpreter. It typically has the sentences that are to be interpreted. An interpreter can do additional tasks using this context.

This pattern is not used very often. In some rare situations, you may need to work with your own programming language. And in a situation like this, this pattern may become handy.