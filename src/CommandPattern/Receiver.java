package CommandPattern;

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
