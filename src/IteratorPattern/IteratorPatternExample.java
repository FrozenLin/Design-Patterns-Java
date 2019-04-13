package IteratorPattern;

public class IteratorPatternExample {
    public static void main(String[] args) {
        Subjects artsSubjects = new Arts();
        Iterator iteratorForArts = artsSubjects.createIterator();
        System.out.println("Arts subjects are as follows:");
        while (iteratorForArts.hasNext()) {
            System.out.println(iteratorForArts.next());
        }
        //Moving back to first element
        iteratorForArts.first();
        System.out.println("Currently pointing back to: " + iteratorForArts.currentItem());
    }
}
