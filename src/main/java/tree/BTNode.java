package tree;

public class BTNode<T> {

    T key;
    BTNode<T> left, right;

    public BTNode(T item) {
        key = item;
    }

    public T getKey() {
        return key;
    }
}
