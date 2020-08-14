public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        if(node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void test() {
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteNode(node3);
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }
}
