public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        for (ListNode node = head.next, pre = head; node != null; node= node.next) {
            if (node.val == pre.val) {
                pre.next = node.next;
            } else {
                pre = node;
            }
        }
        return head;
    }

    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode head = deleteDuplicates(node1);
        for(ListNode node = head; node != null; node = node.next) {
            System.out.println(node.val);
        }

    }
}
