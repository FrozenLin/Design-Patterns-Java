package VisitorPattern;

class MyClass implements OriginalInterface {
    private final int myInt;

    public MyClass() {
        myInt = 5;
    }

    public int getMyInt() {
        return myInt;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }
}
