package IteratorPattern;

public class Arts implements Subjects {
    private String[] papers;

    public Arts() {
        papers = new String[]{"English", "History", "Geography", "Psychology"};
    }

    public Iterator createIterator() {
        return new ArtsIterator(papers);
    }
}
