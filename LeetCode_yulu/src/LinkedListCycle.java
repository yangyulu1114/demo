public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slowrunner = head;
        ListNode fastrunner = head.next; //因为如果都指向第一个节点，那循环直接就退出了，因为fastrunner == slowrunner了

        while (fastrunner != null && fastrunner != slowrunner) {
            slowrunner = slowrunner.next;
            fastrunner = (fastrunner.next == null ? null : fastrunner.next.next);
        }

        return fastrunner != null;
    }

    public void test() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(hasCycle(head));
    }
}
