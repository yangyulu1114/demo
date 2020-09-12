public class MergeTwoSortedLists {

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;

        for (; l1 != null && l2 != null; p = p.next) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
        }

        p.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode tempt = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tempt.next = l1;
                tempt = l1;
                l1 = l1.next;
            } else {
                tempt.next = l2;
                tempt = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            tempt.next = l1;
        }

        if (l2 != null) {
            tempt.next = l2;
        }

        return head;

    }

    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l1node2 = new ListNode(2);
        ListNode l1node3 = new ListNode(4);
        l1.next = l1node2;
        l1node2.next = l1node3;
        l1node3.next = null;

        ListNode l2 = new ListNode(1);
        ListNode l2node2 = new ListNode(3);
        ListNode l2node3 = new ListNode(4);
        l2.next = l2node2;
        l2node2.next = l2node3;
        l2node3.next = null;

        ListNode result = mergeTwoLists3(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
