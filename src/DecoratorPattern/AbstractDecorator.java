package DecoratorPattern;

abstract class AbstractDecorator extends Component {
    protected Component component;

    public void setTheComponent(Component c) {
        component = c;
    }

    public void makeHouse() {
        if (component != null) {
            //Delegating the task
            component.makeHouse();
        }
    }
}
