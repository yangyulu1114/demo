public class ReverseLinkedList {


    public ListNode reverseList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        for (ListNode p = head; p != null; ) {
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }
        return dummy.next;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newhead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    public ListNode reverseList(ListNode head) {
        ListNode tempt = head;
        ListNode prehead = null;

        while (tempt != null) {
            head = tempt;
            tempt = tempt.next;
            head.next = prehead;
            prehead = head;
        }

        return head;
    }


    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l1node2 = new ListNode(2);
        ListNode l1node3 = new ListNode(3);
        ListNode l1node4 = new ListNode(4);
        ListNode l1node5 = new ListNode(5);

        l1.next = l1node2;
        l1node2.next = l1node3;
        l1node3.next = l1node4;
        l1node4.next = l1node5;
        l1node5.next = null;

        ListNode result = reverseList3(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
