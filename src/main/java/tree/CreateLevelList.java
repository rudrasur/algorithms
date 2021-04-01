package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CreateLevelList {

    public static void main(String[] args) {
        BTNode<Integer> root = new BTNode<>(1);
        root.left = new BTNode<>(2);
        root.right = new BTNode<>(3);
        root.left.left = new BTNode<>(4);
        root.left.right = new BTNode<>(5);
        root.right.left = new BTNode<>(6);
        root.right.right = new BTNode<>(7);

        List<LinkedList<BTNode<Integer>>> lists = new ArrayList<>();
        //createLevelListRecursive(root, lists, 0);
        lists = createLevelListIterative(root);

        for (int i=0; i<lists.size(); i++) {
            System.out.print((i+1) + " -> ");
            List<Integer> elements = lists.get(i).stream().map(BTNode::getKey).collect(Collectors.toList());
            System.out.print(elements.toString());
            System.out.println();
        }
    }

    private static List<LinkedList<BTNode<Integer>>> createLevelListIterative(BTNode<Integer> root) {
        List<LinkedList<BTNode<Integer>>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        LinkedList<BTNode<Integer>> current = new LinkedList<>();
        current.add(root);
        while(current.size() > 0) {
            lists.add(current);
            LinkedList<BTNode<Integer>> parents = current;
            current = new LinkedList<>();
            for (BTNode<Integer> parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return lists;
    }

    private static void createLevelListRecursive(
            BTNode<Integer> root,
            List<LinkedList<BTNode<Integer>>> lists,
            int level) {
        if (root == null) {
            return;
        }

        LinkedList<BTNode<Integer>> list = null;
        if (level == lists.size()) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelListRecursive(root.left, lists, level+1);
        createLevelListRecursive(root.right, lists, level+1);
    }
}
