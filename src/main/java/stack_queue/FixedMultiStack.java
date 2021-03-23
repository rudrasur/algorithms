package stack_queue;

import java.util.EmptyStackException;

public class FixedMultiStack {

    private int[] values;
    private int[] sizes;
    private int stackCapacity;
    private int fixedStacks = 3;

    public FixedMultiStack(int stackCapacity) {
        this.stackCapacity = stackCapacity;
        int[] values = new int[stackCapacity * fixedStacks];
        int[] sizes = new int[fixedStacks];
    }

    public void push(int ele, int stackNo) {
        if (isFull(stackNo)) {
            throw new FullStackException();
        }
        sizes[stackNo]++;
        values[sizes[stackNo] + fixedStacks * stackNo] = ele;
    }

    public int pop(int stackNo) {
        if (isEmpty(stackNo)) {
            throw new EmptyStackException();
        }
        int ele = values[sizes[stackNo] + fixedStacks * stackNo];
        sizes[stackNo]--;
        return ele;
    }

    public int peek(int stackNo) {
        if (isEmpty(stackNo)) {
            throw new EmptyStackException();
        }
        return values[sizes[stackNo] + fixedStacks * stackNo];
    }

    public boolean isEmpty(int stackNo) {
        return sizes[stackNo] == 0;
    }

    private boolean isFull(int stackNo) {
        return sizes[stackNo] == stackCapacity;
    }

    public static void main(String[] args) {

    }


}
