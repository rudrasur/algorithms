package linkedlist;

public class Partition {

    public static void main(String[] args) {
        ListNode head = new ListNode(3
                , new ListNode(5
                , new ListNode(8
                , new ListNode(5
                , new ListNode(10
                , new ListNode(2
                , new ListNode(1
                , null )))))));

        System.out.println(head);
        System.out.println(partition(head, 5)
        );

    }

    private static ListNode partition(ListNode node, int key) {
        ListNode head, tail;
        head=tail=node;
        while(node != null) {
            ListNode next = node.next;
            if (node.val < key) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }
}
