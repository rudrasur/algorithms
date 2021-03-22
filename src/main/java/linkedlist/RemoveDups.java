package linkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDups {

    public static void main(String[] args) {
        //[3, 2, 1, 2, 4, 1]
        ListNode head = ListUtils.creatList(new Integer[]{3,2,1,2,4,1});

        System.out.println(head.toString());
        //removeDupsWithBuffer(head);
        removeDupsWithoutBuffer(head);
        System.out.println(head.toString());


    }

    private static void removeDupsWithBuffer(ListNode head) {
        ListNode current = head;
        Set<Integer> values = new HashSet<>();
        ListNode previous = current;
        while (current != null) {
            if (values.contains(current.val)) {
                previous.next = current.next;
            } else {
                values.add(current.val);
                previous = current;
            }
            current = current.next;
        }
    }

    private static void removeDupsWithoutBuffer(ListNode head) {

        ListNode current = head;
        while (current != null) {
            ListNode runner = current.next;
            while (runner != null) {

                if (current.val == runner.val) {
                    current.next = runner.next;
                }
                runner = runner.next;
            }
            current = current.next;
        }

    }
}
