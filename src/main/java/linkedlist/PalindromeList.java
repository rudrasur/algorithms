package linkedlist;

import java.util.Stack;

public class PalindromeList {

    public static void main(String[] args) {
        ListNode head = ListUtils.creatList(new Integer[]{1, 2, 2});
        System.out.println(head);
        System.out.println(isPolindromeReverseMethod(head));
        System.out.println(isPolindromeUsingStack(head));
    }

    private static boolean isPolindromeUsingStack(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        Stack<Integer> firstHalf = new Stack<>();
        while(fast != null && fast.next != null) {
            firstHalf.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        //Handle odd no.of elements
        if (fast != null) {
            slow = slow.next;
        }
        while(slow != null) {
            Integer ele = firstHalf.pop();
            if (ele != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    private static boolean isPolindromeReverseMethod(ListNode head) {
        ListNode r = reverse(head);
        while ( r != null && head != null) {
            if (r.val != head.val) {
                return false;
            }
            r = r.next;
            head = head.next;
        }
        return (r == null && head == null);
    }

    private static ListNode reverse(ListNode node) {
        ListNode head = null;
        while(node != null) {
            ListNode n = new ListNode(node.val);
            n.next = head;
            head = n;
            node = node.next;
        }

        return head;
    }
}
