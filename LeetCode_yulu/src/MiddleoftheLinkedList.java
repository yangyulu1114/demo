public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; length++, cur = cur.next);
        int target = length / 2 + 1;
        ListNode cur = head;
        int count = 0;
        for (; cur != null && count < target - 1; count++, cur = cur.next);
        return cur;
    }
    //快的每次走两步，慢的走一步，这样快的走完，慢的刚好在中间
    public ListNode middleNode2(ListNode head) {
        ListNode faster = head, slower = head;
        for(; faster != null && faster.next != null;) {
            slower = slower.next;
            faster = faster.next.next;
        }
        return slower;
    }
}
