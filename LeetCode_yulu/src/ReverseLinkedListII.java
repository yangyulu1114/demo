public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 1; i < m -1; cur = cur.next, i++);
        ListNode pre = m <= 1? dummy : cur;
        for (cur = pre.next, pre.next = null; cur!= null && m <= n; m++) {
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }
        for (; pre.next != null; pre = pre.next);
        pre.next = cur;
        return dummy.next;
    }

//    本题的思路就是先遍历链表找到要倒转的开始点，然后倒转链表，最后把剩下的部分加到倒转后的链表的尾部
//    edge case [3,5] 1, 2 / [5] 1, 1

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);  //之所以加dummy，是可能从链表的第一个节点开始就要倒转，这时候加上dummy会比较方便倒转
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; pre = pre.next, i++); //这里是为了找到开始倒转起始点的前一个节点pre，通过pre来倒转，pre相当于一个新的dummy
        ListNode cur = pre.next, lastnode = cur; //cur是要到转的第一个节点，last是第一个节点，也是倒转后被倒转部分的最后一个节点
        for (; cur!= null && m <= n; m++) {
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }
        lastnode.next = cur;
        return dummy.next;
    }


    public void test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode result = reverseBetween2(head, 2,4);

        for (ListNode cur = result; cur != null; cur=cur.next) {
            System.out.println(cur.val);
        }
    }
}
