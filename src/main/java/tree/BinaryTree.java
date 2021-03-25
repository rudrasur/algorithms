package tree;

public class BinaryTree {

    BTNode<Integer> root;

    public BinaryTree(Integer key) {
        root = new BTNode<>(key);
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(1);
        tree.root.left = new BTNode<>(2);
        tree.root.right = new BTNode<>(3);

        tree.preOrder(tree.root);
        tree.inOrder(tree.root);
        tree.postOrder(tree.root);

    }
    private void preOrder(BTNode<Integer> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(BTNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }

    private void postOrder(BTNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }

}
