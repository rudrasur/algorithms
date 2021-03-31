package tree;

import java.util.Stack;

public class BinaryTree<T> {

    BTNode<T> root;

    public BinaryTree(T key) {
        root = new BTNode<T>(key);
    }
    public BinaryTree() {
    }

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.root.left = new BTNode<>(2);
        tree.root.right = new BTNode<>(3);

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.inOrderWithoutRecursion(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

    }
    public void preOrder(BTNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.key + "  ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BTNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.key + "  ");
        inOrder(node.right);
    }

    public void inOrderWithoutRecursion(BTNode<T> node) {
        Stack<BTNode<T>> st = new Stack<>();
        if (node == null) {
            return;
        }
        while(node != null || !st.isEmpty()) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
            node = st.pop();
            System.out.print(node.key + "  ");
            node = node.right;
        }
    }

    public void postOrder(BTNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + "  ");
    }

}
