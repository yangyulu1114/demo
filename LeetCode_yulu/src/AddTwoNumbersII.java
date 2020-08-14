import java.util.List;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode ans = add(l1, l2);
        return reverse(ans);
    }

    public ListNode reverse(ListNode node) {
        ListNode dummy = new ListNode(0);
        for (; node != null; ) {
            ListNode next = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = next;
        }
        return dummy.next;
    }
    public ListNode add(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), head = dummy;
        int increment = 0;
        for (; l1 != null || l2 != null || increment != 0; ) {
            if (l1 != null) {
                increment += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                increment += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(increment % 10);
            head.next = node;
            head = node;
            increment /= 10;
        }
        return dummy.next;
    }
}
