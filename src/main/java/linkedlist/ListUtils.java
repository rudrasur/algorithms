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

    public static ListNode getTail(ListNode head) {
        ListNode tail = head;
        while(head != null) {
            tail = head;
            head = head.next;
        }
        return tail;
    }
}
