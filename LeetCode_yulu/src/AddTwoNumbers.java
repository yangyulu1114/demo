//要注意结果输出的顺序
//edge case两个链表都到尾部了，但是有进位的情况 [5],[5]
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), head = dummy;
        int increment = 0;
        for (ListNode cur1 = l1, cur2 = l2; cur1 != null || cur2!= null || increment != 0;) {
            int sum = increment;
            if (cur1 != null) {
                sum += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                sum += cur2.val;
                cur2 = cur2.next;
            }
            increment = sum / 10;
            ListNode node = new ListNode(sum % 10);
            head.next = node;
            head = node;
        }
        return dummy.next;
    }

    public void test() {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode sum = addTwoNumbers(l1, l2);

        for (ListNode cur = sum; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }
}
