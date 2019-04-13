package MementoPattern;

class Memento {
    private int stateId;

    public Memento(int stateId) {
        this.stateId = stateId;
    }

    public int getStateId() {
        return stateId;
    }

    /*This class does not have the
    setter method.We need to use this class
    to get the state of the object only.*/
    /*public void setState(String state) {
        this.state = state;
    }*/
}
