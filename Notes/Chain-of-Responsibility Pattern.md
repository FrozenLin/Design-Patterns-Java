### Chain-of-Responsibility Pattern

##### GoF Definition

> Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.

##### Programmatic Example

MessagePriority has two types of priority.

```java
enum MessagePriority {
    NORMAL,
    HIGH
}
```

Message class

```java
public class Message {
    public String text;
    public MessagePriority priority;

    public Message(String msg, MessagePriority p) {
        text = msg;
        this.priority = p;
    }
}
```

Receiver interface

```java
interface Receiver {
    boolean handleMessage(Message message);

    void nextErrorHandler(Receiver nextReceiver);
}
```

IssueRaiser class

```java
public class IssueRaiser {
    public Receiver setFirstReceiver;

    public void setFirstErrorHandler(Receiver firstErrorHandler) {
        this.setFirstReceiver = firstErrorHandler;
    }

    public void raiseMessage(Message message) {
        if (setFirstReceiver != null) {
            setFirstReceiver.handleMessage(message);
        }
    }
}
```

Two different types of error handlers. EmailErrorHandler and FaxErrorHandler.

```java
public class FaxErrorHandler implements Receiver {
    private Receiver nextReceiver;

    @Override
    public void nextErrorHandler(Receiver nextReceiver) {
        this.nextReceiver = nextReceiver;
    }

    @Override
    public boolean handleMessage(Message message) {
        if (message.text.contains("Fax")) {
            System.out.println(" FaxErrorHandler processed " + message.priority + " priority issue :" + message.text);
            return true;
        } else {
            if (nextReceiver != null)
                nextReceiver.handleMessage(message);
        }
        return false;
    }
}
```

```java
public class EmailErrorHandler implements Receiver {
    private Receiver nextReceiver;

    @Override
    public void nextErrorHandler(Receiver nextReceiver) {
        this.nextReceiver = nextReceiver;
    }

    @Override
    public boolean handleMessage(Message message) {
        if (message.text.contains("Email")) {
            System.out.println(" EmailErrorHandler processed " + message.priority + " priority issue: " + message.text);
            return true;
        } else {
            if (nextReceiver != null)
                nextReceiver.handleMessage(message);
        }
        return false;
    }
}
```

class ChainofResponsibilityPattern.

```java
public class ChainofResponsibilityPattern {
    public static void main(String[] args) {
        /* Forming the chain as IssueRaiser->FaxErrorhandler-> EmailErrorHandler*/
        Receiver faxHandler, emailHandler;
        //Objects of the chains
        IssueRaiser issueRaiser = new IssueRaiser();
        faxHandler = new FaxErrorHandler();
        emailHandler = new EmailErrorHandler();
        //Making the chain
        //Starting point:IssueRaiser will raise issues and set the first handler
        issueRaiser.setFirstErrorHandler(faxHandler);
        //FaxErrorHandler will pass the error to EmailHandler if needed.
        faxHandler.nextErrorHandler(emailHandler);
        //EmailErrorHandler will be placed at the last position in the chain
        emailHandler.nextErrorHandler(null);

        Message m1 = new Message("Fax is going slow.", MessagePriority.NORMAL);
        Message m2 = new Message("Emails are not reaching.", MessagePriority.HIGH);
        Message m3 = new Message("In Email, CC field is disabled always.", MessagePriority.NORMAL);
        Message m4 = new Message("Fax is not reaching destinations.", MessagePriority.HIGH);
        issueRaiser.raiseMessage(m1);
        issueRaiser.raiseMessage(m2);
        issueRaiser.raiseMessage(m3);
        issueRaiser.raiseMessage(m4);
    }
}
```

Result

```markdown
FaxErrorHandler processed NORMAL priority issue :Fax is going slow.
EmailErrorHandler processed HIGH priority issue: Emails are not reaching.
EmailErrorHandler processed NORMAL priority issue: In Email, CC field is disabled always.
FaxErrorHandler processed HIGH priority issue :Fax is not reaching destinations.
```

##### Real-World Example

java.util.loggin.Logger

doFilter(ServletRequest request, ServletResponse response, FilterChain chain) in javax.Servlet.Filter.

##### Analysis

In this pattern, you form a chain of objects where each object in the chain handles a particular kind of request. If an object cannot handle the request fully, it passes the request to the next object in the chain. The same process may follow until the end of a chain is reached.