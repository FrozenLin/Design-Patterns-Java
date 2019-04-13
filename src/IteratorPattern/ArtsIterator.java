package IteratorPattern;

public class ArtsIterator implements Iterator {
    private String[] papers;
    private int position;

    public ArtsIterator(String[] papers) {
        this.papers = papers;
        position = 0;
    }

    @Override
    public void first() {
        position = 0;
    }

    @Override
    public String next() {
        //System.out.println("Currently pointing to: "+ this.currentItem());
        return papers[position++];
    }

    @Override
    public String currentItem() {
        return papers[position];
    }

    @Override
    public boolean hasNext() {
        if (position >= papers.length)
            return false;
        return true;
    }
}
