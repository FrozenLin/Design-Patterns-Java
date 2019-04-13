### Template Method Pattern

##### GoF Definition

> Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

##### Programmatic Example

We have a BasicEngineering class. This class contains completeCourse() method which serve for cs or ee student.

```java
abstract class BasicEngineering {
    public final void completeCourse() {
        // The course needs to be completed in the following sequence.
        // Math-SoftSkills-Special Paper
        completeMath();
        completeSoftSkills();
        completeSpecialPaper();
    }

    private void completeMath() {
        System.out.println("1.Mathematics");
    }

    private void completeSoftSkills() {
        System.out.println("2.SoftSkills");
    }

    public abstract void completeSpecialPaper();
}
```

Concrete classes. They implement completeSpecialPaper() method according to their needs.

```java
public class ComputerScience extends BasicEngineering {
    @Override
    public void completeSpecialPaper() {
        System.out.println("3.Object-Oriented Programming");
    }
}
```

```java
public class Electronics extends BasicEngineering {
    @Override
    public void completeSpecialPaper() {
        System.out.println("3.Digital Logic and Circuit Theory");
    }
}
```

TemplateMethodPatternExample class.

```java
public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        BasicEngineering preferredCourse = new ComputerScience();
        System.out.println("Computer Sc. course will be completed in following order:");
        preferredCourse.completeCourse();
        System.out.println();
        preferredCourse = new Electronics();
        System.out.println("Electronics course will be completed in following order:");
        preferredCourse.completeCourse();
    }
}
```

Result

```markdown
Computer Sc. course will be completed in following order:
1.Mathematics
2.SoftSkills
3.Object-Oriented Programming

Electronics course will be completed in following order:
1.Mathematics
2.SoftSkills
3.Digital Logic and Circuit Theory
```

##### Real-World

removeAll() method of java.util.AbstractSet.

##### Analysis

You can control the flow of the algorithms. 

Common operations are placed in a centralized location, for example, in an abstract class.