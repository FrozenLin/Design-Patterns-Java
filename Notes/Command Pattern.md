### Command Pattern

##### GoF Definition

> Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queues, or log requests, and supports undoable operations.

##### Programmatic Example

Command interface.

```java
public interface Command {
    //Typically this method does not take any argument.
    //Some of the reasons are:
    //1.We supply all the information when it is created.
    //2.Invoker may reside in different address space.etc.
    void executeCommand();
}
```

Two commands, undo and redo.

```java
public class MyUndoCommand implements Command {
    private Receiver receiver;

    public MyUndoCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void executeCommand() {
        //Perform any optional task prior to UnDo
        receiver.doOptionalTaskPriorToUndo();
        //Call UnDo in receiver now
        receiver.performUndo();
    }
}
```

```java
public class MyRedoCommand implements Command {
    private Receiver receiver;

    public MyRedoCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void executeCommand() {
        //Perform any optional task prior to ReDo
        receiver.doOptionalTaskPriorToRedo();
        //Call ReDo in receiver now
        receiver.performRedo();
    }
}
```

Receiver

```java
public class Receiver {
    public void performUndo() {
        System.out.println("Performing an undo command in Receiver.");
    }

    public void performRedo() {
        System.out.println("Performing an redo command in Receiver.");
    }

    public void doOptionalTaskPriorToUndo() {
        System.out.println("Executing -Optional Task/s prior to execute undo command.");
    }

    public void doOptionalTaskPriorToRedo() {
        System.out.println("Executing -Optional Task/s prior to execute redo command.");
    }
}
```

Invoker

```java
public class Invoker {
    Command commandToBePerformed;

    //Alternative approach:
    //You can also initialize the invoker with a command object
//    public Invoker(Command command) {
//        this.commandToBePerformed = command;
//    }

    public void setCommand(Command command) {
        this.commandToBePerformed = command;
    }

    public void invokeCommand() {
        commandToBePerformed.executeCommand();
    }

}
```

CommandPatternExample class.

```java
public class CommandPatternExample {
    public static void main(String[] args) {
        /*Client holds both the Invoker and Command Objects*/
        Receiver intendedReceiver = new Receiver();
        MyUndoCommand undoCmd = new MyUndoCommand(intendedReceiver);
        //If you use parameterized constructor of Invoker
        //use the following line of code.
//    Invoker invoker = new Invoker(undoCmd);
        Invoker invoker = new Invoker();
        invoker.setCommand(undoCmd);
        invoker.invokeCommand();
        MyRedoCommand redoCmd = new MyRedoCommand(intendedReceiver);
        invoker.setCommand(redoCmd);
        invoker.invokeCommand();
    }
}
```

Result

```markdown
Executing -Optional Task/s prior to execute undo command.
Performing an undo command in Receiver.
Executing -Optional Task/s prior to execute redo command.
Performing an redo command in Receiver.
```

##### Real-World Example

implement run() method of java.lang.Runnable interface.

java.swing.Action

##### Analysis

invoker, client, command, and receiver. 

> A command object can invoke a method of the receiver in a way that is specific to that receiver’s class. The receiver then starts processing the job. A command object is separately passed to the invoker object to invoke the command. The client object holds the invoker object and the command objects. The client only makes the decision—which commands to execute—and then it passes the command to the invoker object (for that execution).