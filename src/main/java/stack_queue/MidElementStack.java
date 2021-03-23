package stack_queue;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MidElementStack {

    public static void main(String[] args) {
        MidElementStack s = new MidElementStack();
        s.push(1); // t:1, m: 1
        System.out.println("t: " + s.peek() + ", m: " + s.findMiddle());
        s.push(2); // t:2, m: 1
        System.out.println("t: " + s.peek() + ", m: " + s.findMiddle());
        s.push(3); // t:3, m: 2
        System.out.println("t: " + s.peek() + ", m: " + s.findMiddle());
        s.push(4); // t:4, m: 2
        System.out.println("t: " + s.peek() + ", m: " + s.findMiddle());
        s.push(5); // t:5, m: 3
        System.out.println("t: " + s.peek() + ", m: " + s.findMiddle());
        s.pop(); // t: 4, m: 2
        System.out.println("t: " + s.peek() + ", m: " + s.findMiddle());
        s.pop(); // t:3, m: 2
        System.out.println("t: " + s.peek() + ", m: " + s.findMiddle());
        s.pop(); // t:2, m: 1
        System.out.println("t: " + s.peek() + ", m: " + s.findMiddle());
        s.pop(); // t: 1, m: 1
        System.out.println("t: " + s.peek() + ", m: " + s.findMiddle());
        s.pop(); // exception
        System.out.println("t: " + s.peek() + ", m: " + s.findMiddle());

    }

    private DoubleLinkedList head;
    private DoubleLinkedList tail;
    private DoubleLinkedList mid;

    public void push(Integer x) {
        if (head == null) {
            head = tail = mid = new DoubleLinkedList(x);
            head.size = 1;
            return;
        }
        DoubleLinkedList node = new DoubleLinkedList(x);
        tail.next = node;
        node.previous = tail;
        tail = node;
        head.size++;
        if(head.size % 2 == 1) {
            mid = mid.next;
        }
    }

    public Integer pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        if (head.size == 1) {
            int x = head.data;
            head = mid = tail = null;
            return x;
        }
        head.size--;
        int x = tail.data;
        tail = tail.previous;
        tail.next = null;
        if (head.size % 2 == 0 && mid.previous != null) {
            mid = mid.previous;
        }
        return x;
    }

    public Integer findMiddle() {
        if (mid == null) {
            throw new EmptyStackException();
        }
        return mid.data;
    }

    public Integer peek() {
        if (tail == null) {
            throw new EmptyStackException();
        }
        return tail.data;
    }
}

class DoubleLinkedList {

    Integer data;
    DoubleLinkedList next;
    DoubleLinkedList previous;
    int size;

    public DoubleLinkedList(Integer data) {
        this.data = data;
    }
}
