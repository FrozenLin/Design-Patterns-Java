### Iterator Pattern

##### GoF Definition

> Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

##### Programmatic Example

Subjects Interface.

```java
interface Subjects {
    Iterator createIterator();
}
```

Arts class

```java
public class Arts implements Subjects {
    private String[] papers;

    public Arts() {
        papers = new String[]{"English", "History", "Geography", "Psychology"};
    }

    public Iterator createIterator() {
        return new ArtsIterator(papers);
    }
}
```

And Iterator interface.

```java
interface Iterator {
    void first();//Reset to first element

    String next();//To get the next element

    String currentItem();//To retrieve the current element

    boolean hasNext();//To check whether there is any next element or not.
}
```

And ArtsIterator will implement methods in Iterator interface.

```java
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
```

IteratorPatternExample class.

```java
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
```

Result

```markdown
Arts subjects are as follows:
English
History
Geography
Psychology
Currently pointing back to: English
```

##### Real-World Example

java.util.Iterator

java.util.enumeration

##### Analysis

Using iterators, a client object can traverse a container (or a collection of objects) to access its elements without knowing how these data are stored internally.