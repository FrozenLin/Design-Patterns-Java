package VisitorPattern;

class VisitorPatternExample {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        MyClass myClass = new MyClass();
        myClass.acceptVisitor(visitor);
    }
}
