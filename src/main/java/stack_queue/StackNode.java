package stack_queue;

public class StackNode<T> {

    T data;
    StackNode<T> next;

    public StackNode(T data) {
        this.data = data;
    }
}
