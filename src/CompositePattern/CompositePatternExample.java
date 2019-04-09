package CompositePattern;

public class CompositePatternExample {
    public static void main(String[] args) {
        // Math teachers
        Employee mathTeacher1 = new Employee("Math Teacher-1", "Maths");
        Employee mathTeacher2 = new Employee("Math Teacher-2", "Maths");

        // CS teachers
        Employee cseTeacher1 = new Employee("CSE Teacher-1", "Computer Sc.");
        Employee cseTeacher2 = new Employee("CSE Teacher-2", "Computer Sc.");
        Employee cseTeacher3 = new Employee("CSE Teacher-3", "Computer Sc.");

        // 2 heads of the two departments
        CompositeEmployee hodMaths = new CompositeEmployee("Mrs.S.Das(HOD-Maths)", "Maths");
        CompositeEmployee hodCompSc = new CompositeEmployee("Mr.S.Sarcar(HOD-CSE)", "Computer Sc.");

        // Principle of college
        CompositeEmployee principal = new CompositeEmployee("Dr.S.Som(Principal)", "Managing");

        hodMaths.addEmployee(mathTeacher1);
        hodMaths.addEmployee(mathTeacher2);

        hodCompSc.addEmployee(cseTeacher1);
        hodCompSc.addEmployee(cseTeacher2);
        hodCompSc.addEmployee(cseTeacher3);

        principal.addEmployee(hodMaths);
        principal.addEmployee(hodCompSc);

        // Test the structures
        principal.printStructures();
        System.out.println("At present Principal has control over " + principal.getEmployeeCount()
                + " number of employees.");

        hodCompSc.printStructures();
        System.out.println("At present HOD-CSE has control over " + hodCompSc.getEmployeeCount()
                + " number of employees.");
        hodMaths.printStructures();
        System.out.println("At present HOE-Maths has control over " + hodMaths.getEmployeeCount()
                + " number of employees.");

        // Leaf node
        mathTeacher1.printStructures();
        System.out.println("At present Math Teacher-1 has control over " + mathTeacher1.getEmployeeCount()
                + " number of employees.");

        // Suppose, one cs teacher is leaving now.
        hodCompSc.removeEmployee(cseTeacher2);
        principal.printStructures();
        System.out.println("At present Principal has control over " + principal.getEmployeeCount()
                + " number of employees.");
        System.out.println("At present HOD-CSE has control over " + hodCompSc.getEmployeeCount()
                + " number of employees.");
        System.out.println("At present HOE-Maths has control over " + hodMaths.getEmployeeCount()
                + " number of employees.");

    }
}
