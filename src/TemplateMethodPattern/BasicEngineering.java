package TemplateMethodPattern;

abstract class BasicEngineering {
    public final void completeCourse() {
        // The course needs to be completed in the following sequence.
        // Math-SoftSkills-Special Paper
        completeMath();
        completeSoftSkills();
        completeSpecialPaper();
    }

    private void completeMath() {
        System.out.println("1.Mathematics");
    }

    private void completeSoftSkills() {
        System.out.println("2.SoftSkills");
    }

    public abstract void completeSpecialPaper();
}
