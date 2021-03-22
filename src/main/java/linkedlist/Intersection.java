package linkedlist;

public class Intersection {

    public static void main(String[] args) {
        ListNode a = ListUtils.creatList(new Integer[]{3,1,5,9});
        ListNode b = ListUtils.creatList(new Integer[]{4,6});
        ListNode t = ListUtils.creatList(new Integer[]{7,2,1});
        ListUtils.getTail(a).next = t;
        ListUtils.getTail(b).next = t;
        System.out.println(a);
        System.out.println(b);
        System.out.println(intersection(a, b));
    }

    private static Result getSizeAndTail(ListNode head) {
        int n = 0;
        ListNode tail = head;
        while(head != null) {
            tail = head;
            head = head.next;
            n++;
        }
        return new Result(n, tail);
    }

    private static ListNode findKth(ListNode head, int k) {
        while(k > 0 && head != null) {
            head = head.next;
            k--;
        }
        return head;
    }

    private static ListNode intersection(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return null;
        }
        Result r1 = getSizeAndTail(a);
        Result r2 = getSizeAndTail(b);

        if (r1.tail != r2.tail) {
            return null;
        }
        ListNode longer = r1.n > r2.n ? a : b;
        ListNode shorter = r1.n < r2.n ? a : b;
        longer = findKth(longer, Math.abs(r1.n-r2.n));
        while(longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }
}

class Result {
    int n;
    ListNode tail;

    public Result(int n, ListNode tail) {
        this.n = n;
        this.tail = tail;
    }
}