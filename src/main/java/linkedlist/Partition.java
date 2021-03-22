package linkedlist;

public class Partition {

    public static void main(String[] args) {
        ListNode head = ListUtils.creatList(new Integer[]{3,5,8,5,10,2,1});

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
