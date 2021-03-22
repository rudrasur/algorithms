package stack_queue;

import java.util.NoSuchElementException;

public class MyQueue<T> {

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T data) {
        QueueNode<T> node = new QueueNode<>(data);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = last;
        }
    }

    private T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    private T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
