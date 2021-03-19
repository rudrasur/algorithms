package linkedlist;

public class ListUtils {

    public static ListNode creatList(Integer[] values) {
        ListNode head = new ListNode();
        ListNode current = head;
        for (Integer val: values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return head.next;
    }
}
