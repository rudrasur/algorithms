package linkedlist;

public class FindKthToLast {

    public static void main(String[] args) {

        ListNode head = new ListNode(3
                , new ListNode(4
                , new ListNode(5
                , new ListNode(7
                , new ListNode(8
                , new ListNode(9
                , null ))))));

        System.out.println(findKthElementFromLast(head, 3));
        printKthToLast(head, 3);
    }

    private static int printKthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int idx = printKthToLast(head.next, k) + 1;
        if (idx == k) {
            System.out.println("Recursive: " + k + "th element is: " + head.val);
        }
        return idx;
    }

    private static int findKthElementFromLast(ListNode head, int k) {
        int n, desiredCount;
        n = 0;
        ListNode current = head;
        while(current != null) {
            current = current.next;
            n++;
        }
        desiredCount = n - k;
        int i=0;
        current = head;
        while(current != null) {
            if (i == desiredCount) {
                return current.val;
            }
            current = current.next;
            i++;
        }
        return -1;
    }
}
