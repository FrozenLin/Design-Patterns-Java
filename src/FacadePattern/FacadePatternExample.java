package FacadePattern;

public class FacadePatternExample {
    public static void main(String[] args) {
        // Creating Robots
        RobotFacade milanoRobotFacade = new RobotFacade();
        milanoRobotFacade.constructMilanoRobot();
        RobotFacade robonautRobotFacade = new RobotFacade();
        robonautRobotFacade.constructRobonautRobot();

        // Destroying Robots
        milanoRobotFacade.destroyMilanoRobot();
        robonautRobotFacade.destroyRobonautRobot();
    }
}
