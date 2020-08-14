public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA), lengthB = getLength(headB);
        int diff = Math.abs(lengthA - lengthB);
        ListNode longlist = lengthA > lengthB ? headA : headB;
        ListNode shortlist = lengthA > lengthB ? headB : headA;

        for (int i = 1; i <= diff; i++) {
            longlist = longlist.next;
        }
        for (;longlist != null && shortlist != null; longlist = longlist.next, shortlist = shortlist.next) {
            if (longlist == shortlist) {
                return longlist;
            }
        }
        return  null;
    }

    public int getLength(ListNode head) {
        int length = 0;
        for (; head != null; head = head.next) {
            length ++;
        }
        return length;
    }

    public void test() {
        ListNode headA = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode headB = new ListNode(5);
        ListNode node5 = new ListNode(0);
        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        headB.next = node5;
        node5.next = node1;
        System.out.println(getIntersectionNode(headA, headB).val);
    }
}
