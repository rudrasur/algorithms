package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOperations {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        tree.root.left = new BTNode<>(11);
        tree.root.left.left = new BTNode<>(7);
        tree.root.right = new BTNode<>(9);
        tree.root.right.left = new BTNode<>(15);
        tree.root.right.right = new BTNode<>(8);

        System.out.println("In order - before insert: ");
        tree.inOrder(tree.root);
        System.out.println();
        insertLevelOrder(tree, 12);
        System.out.println("In order - after insert: ");
        tree.inOrder(tree.root);
        /*
                     10
                   /    \
                  11     9
                 /  \   /  \
                7   12 15   8
         */
        System.out.println();
        deleteKey(tree.root, 10);
        System.out.println("After delete: ");
        /*
                     8
                   /    \
                  11     9
                 /  \   /
                7   12 15
         */
        tree.inOrder(tree.root);
    }

    private static void insertLevelOrder(BinaryTree<Integer> tree, int key) {
        BTNode<Integer> root = tree.root;
        if (root == null) {
            tree.root = new BTNode<>(key);
            return;
        }
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            BTNode temp = q.peek();
            q.remove();
            if (temp.left == null) {
                temp.left = new BTNode(key);
                break;
            } else {
                q.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = new BTNode(key);
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    private static void deleteKey(BTNode root, int key) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);
        BTNode<Integer> current, keyNode;
        current = keyNode = null;
        while(!q.isEmpty()) {
            current = q.peek();
            q.remove();
            if (current.key == key) {
                keyNode = current;
            }
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
        if (keyNode != null) {
            int x = current.key;
            deleteDeepest(root, current);
            keyNode.key = x;
        }
    }

    private static void deleteDeepest(BTNode<Integer> root, BTNode<Integer> keyNode) {
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);
        BTNode<Integer> temp = null;
        while(!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            if (temp == keyNode) {
                temp = null;
                return;
            }
            if (temp.left == keyNode) {
                temp.left = null;
                return;
            } else {
                q.add(temp.left);
            }
            if (temp.right == keyNode) {
                temp.right = null;
                return;
            } else {
                q.add(temp.right);
            }
        }
    }
}
