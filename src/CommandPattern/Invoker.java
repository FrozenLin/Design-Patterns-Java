package CommandPattern;

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
