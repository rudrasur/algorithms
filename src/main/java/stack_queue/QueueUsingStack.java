package stack_queue;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueUsingStack {

    public static void main(String[] args) {
        QueueUsingStack qus = new QueueUsingStack();
        qus.enQueue(1);
        qus.enQueue(2);
        qus.enQueue(3);

        System.out.println(qus.deQueue()); // should print 1
        System.out.println(qus.deQueue()); // should print 2
        System.out.println(qus.deQueue()); // should print 3
        System.out.println(qus.deQueue()); // EmptyStackException

    }

    private Stack<Integer> s = new Stack<>();

    public void enQueue(Integer x) {
        s.push(x);
    }

    public Integer deQueue() {
        if (s.isEmpty()) {
            throw new EmptyStackException();
        }
        if (s.size() == 1) {
            return s.pop();
        }
        Integer x = s.pop();
        Integer res = deQueue();
        s.push(x);
        return res;
    }
}
