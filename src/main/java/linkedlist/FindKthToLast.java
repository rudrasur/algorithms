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
        System.out.println(findKthLast(head, 3).val);
    }

    private static ListNode findKthLast(ListNode head, int k) {

        ListNode p1, p2;
        p1 = p2 = head;
        for (int i=0; i<k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
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
