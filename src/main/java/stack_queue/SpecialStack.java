package stack_queue;

import java.util.EmptyStackException;
import java.util.Stack;

public class SpecialStack extends Stack<Integer> {

    private Stack<Integer> min = new Stack<>();

    public void push(int x) {
        if (isEmpty()) {
            min.push(x);
            super.push(x);
            return;
        }
        int m = min.peek();
        if (m > x) {
            min.push(x);
        } else {
            min.push(m);
        }
        super.push(x);
    }

    public Integer pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        min.pop();
        return super.pop();
    }

    public Integer getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        SpecialStack s = new SpecialStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
    }

}
