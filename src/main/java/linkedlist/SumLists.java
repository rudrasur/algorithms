package linkedlist;

public class SumLists {

    public static void main(String[] args) {
        ListNode a = ListUtils.creatList(new Integer[]{7,1,6});
        ListNode b = ListUtils.creatList(new Integer[]{5,9,2});

        System.out.println(sumLists(a, b));
        System.out.println(addLists(a, b, 0));
    }

    private static ListNode addLists(ListNode a, ListNode b, int carry) {
        if (a == null && b == null && carry == 0) {
            return null;
        }
        ListNode result = new ListNode();
        int val = carry;
        if (a != null) {
            val += a.val;
        }
        if (b != null) {
            val += b.val;
        }
        result.val = val % 10;
        if (a != null || b != null) {
            result.next = addLists( a == null ? null : a.next,
                                    b == null ? null : b.next,
                                    val >= 10 ? 1 : 0);
        }
        return result;
    }

    private static ListNode sumLists(ListNode a, ListNode b) {

        int aNum = 0;
        int bNum = 0;
        int dec = 1;
        while( a != null ) {
            if (aNum == 0) {
                aNum = a.val;
            } else {
                aNum = a.val * dec + aNum;
            }
            a = a.next;
            dec *= 10;
        }
        dec = 1;
        while(b != null) {
            if (bNum == 0) {
                bNum = b.val;
            } else {
                bNum = b.val * dec + bNum;
            }
            dec *= 10;
            b = b.next;
        }
        System.out.println(aNum + ", " + bNum);
        int sum = aNum + bNum;
        ListNode head = null;
        while (sum > 0) {
            ListNode t = head;
            head = new ListNode(sum % 10);
            head.next = t;
            sum /= 10;
        }
        return head;
    }
}

