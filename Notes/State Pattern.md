### State Pattern

##### GoF Definition

> Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.

##### Programmatic Example

This example shows the implementation of remote control of television. The TV has three states: On, Off, or Mute.

TV class is the main class. Client code only talks to it.

```java
class TV {
    private PossibleState currentState;

    public TV() {
        //Initially TV is initialized with Off state
        this.setCurrentState(new Off());
    }

    public PossibleState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(PossibleState currentState) {
        this.currentState = currentState;
    }

    public void pressOffButton() {
        currentState.pressOffButton(this);//Delegating the state
    }

    public void pressOnButton() {
        currentState.pressOnButton(this);//Delegating the state
    }

    public void pressMuteButton() {
        currentState.pressMuteButton(this);//Delegating the state
    }
}
```

PossibleState is an interface that defines the operations on objects.

```java
public interface PossibleState {
    void pressOnButton(TV context);

    void pressOffButton(TV context);

    void pressMuteButton(TV context);
}
```

On, Off and Mute are concrete states that implement the PossibleState interface.

```java
class On implements PossibleState {
    @Override
    public void pressOnButton(TV context) {
        System.out.println("You pressed On button. TV is already in On state.");
    }

    public void pressOffButton(TV context) {
        System.out.println("You pressed Off button.Going from On to Off state.");
        context.setCurrentState(new Off());
        System.out.println(context.getCurrentState().toString());
    }

    public void pressMuteButton(TV context) {
        System.out.println("You pressed Mute button.Going from On to Mute mode.");
        context.setCurrentState(new Mute());
        System.out.println(context.getCurrentState().toString());
    }

    public String toString() {
        return "\t**TV is switched on now.**";
    }
}
```

```java
class Off implements PossibleState {
    @Override
    public void pressOnButton(TV context) {
        System.out.println("You pressed On button. Going from Off to On state.");
        context.setCurrentState(new On());
        System.out.println(context.getCurrentState().toString());
    }

    @Override
    public void pressOffButton(TV context) {
        System.out.println("You pressed Off button. TV is already in Off state.");
    }

    @Override
    public void pressMuteButton(TV context) {
        System.out.println("You pressed Mute button. TV is already in Off state," +
                "so Mute operation will not work.");
    }

    @Override
    public String toString() {
        return "\t**TV is switched off now.**";
    }
}
```

```java
class Mute implements PossibleState {
    @Override
    public void pressOnButton(TV context) {
        System.out.println("You pressed On button.Going from Mute mode to On state.");
        context.setCurrentState(new On());
        System.out.println(context.getCurrentState().toString());
    }

    @Override
    public void pressOffButton(TV context) {
        System.out.println("You pressed Off button. Going from Mute mode to Off state.");
        context.setCurrentState(new Off());
        System.out.println(context.getCurrentState().toString());
    }

    @Override
    public void pressMuteButton(TV context) {
        System.out.println("You pressed Mute button.TV is already in Mute mode.");
    }

    public String toString() {
        return "\t**TV is silent(mute) now**";
    }
}
```

StatePatternExample class.

```java
public class StatePatternExample {
    public static void main(String[] args) {
        //Initially TV is Off.
        TV tv = new TV();
        System.out.println("User is pressing buttons in the following sequence:");
        System.out.println("Off->Mute->On->On->Mute->Mute->Off");
        //TV is already in Off state.Again Off button is pressed.
        tv.pressOffButton();
        //TV is already in Off state.Again Mute button is pressed.
        tv.pressMuteButton();
        //Making the TV on
        tv.pressOnButton();
        //TV is already in On state.Again On button is pressed.
        tv.pressOnButton();
        //Putting the TV in Mute mode
        tv.pressMuteButton();
        //TV is already in Mute mode.Again Mute button is pressed.
        tv.pressMuteButton();
        //Making the TV off
        tv.pressOffButton();
    }
}
```

Result

```markdown
User is pressing buttons in the following sequence:
Off->Mute->On->On->Mute->Mute->Off
You pressed Off button. TV is already in Off state.
You pressed Mute button. TV is already in Off state,so Mute operation will not work.
You pressed On button. Going from Off to On state.
	**TV is switched on now.**
You pressed On button. TV is already in On state.
You pressed Mute button.Going from On to Mute mode.
	**TV is silent(mute) now**
You pressed Mute button.TV is already in Mute mode.
You pressed Off button. Going from Mute mode to Off state.
	**TV is switched off now.**
```

##### Real-World Example

javax.faces.lifecycle.Lifecycle has a method execute(FacesContext context).

##### Analysis

If you want to design similar kinds of behavior changes of an object when it’s internal state changes, this pattern is useful.