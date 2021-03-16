package linkedlist;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this. val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {

        String out = "";
        ListNode current = this;
        while (current != null) {
            out += current.val + " ";
            current = current.next;
        }
        return out;
    }
}
