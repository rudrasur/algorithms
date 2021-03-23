package stack_queue;

import java.util.EmptyStackException;
import java.util.PriorityQueue;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args) {

        StackUsingQueue sq = new StackUsingQueue();
        sq.push(1);
        sq.push(2);
        sq.push(3);

        System.out.println(sq.peek()); // should return 3
        System.out.println(sq.pop()); // should return 3
        System.out.println(sq.peek()); //should return 2
        System.out.println(sq.pop()); //should return 2
    }

    private Queue<Integer> q = new PriorityQueue<>();

    public void push(Integer x) {
        q.add(x);
    }

    public Integer pop(){
        if (q.isEmpty()) {
            throw new EmptyStackException();
        }
        if (q.size() == 1) {
            return q.poll();
        }
        Integer x = q.poll();
        Integer res = pop();
        q.add(x);
        return res;
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public Integer peek() {
        if (q.isEmpty()) {
            throw new EmptyStackException();
        }
        if (q.size() == 1) {
            return q.peek();
        }
        Integer x = q.poll();
        Integer res = peek();
        q.add(x);
        return res;
    }
}
