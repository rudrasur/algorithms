package tree;

public class MinimalBSTCreation {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        BinaryTree<Integer> bt = new BinaryTree();
        BTNode<Integer> root = createMinimalBST(arr, 0, arr.length-1);
        bt.inOrder(root);
    }

    private static BTNode<Integer> createMinimalBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start+end)/2;
        BTNode<Integer> root = new BTNode<>(arr[mid]);
        root.left = createMinimalBST(arr, start, mid-1);
        root.right = createMinimalBST(arr, mid+1, end);
        return root;
    }
}
