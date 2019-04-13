package StatePattern;

public interface PossibleState {
    void pressOnButton(TV context);

    void pressOffButton(TV context);

    void pressMuteButton(TV context);
}
