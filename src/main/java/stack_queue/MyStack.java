package stack_queue;

import java.util.EmptyStackException;

public class MyStack<T> {

    private StackNode<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        StackNode<T> top = this.top;
        this.top = top.next;
        return top.data;
    }

    public void push(T data) {
        StackNode<T> node = new StackNode<>(data);
        node.next = top;
        top = node;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
