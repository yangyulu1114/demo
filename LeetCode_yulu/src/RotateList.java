public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0, step = 1;
        ListNode temp = head;
        for (; temp != null; temp = temp.next, length++) ;//求数组长度
        //需要判断length == 0 ，否则k % length会无效； k 是length的倍数时，相当于不用rotate
        if (length == 0 || k % length == 0) {
            return head;
        }
        k = k % length;
        for (temp = head; temp != null && step < length - k; temp = temp.next, step++) ;
        ListNode newhead = temp.next, next = newhead;
     //  如果出现不用位移的情况，newhead会为null
        // if (next == null) {
        //     return head;
        // }
        temp.next = null;
        for (; next.next != null; next = next.next);
        next.next = head;
        return  newhead;
    }
//    public ListNode rotateRight2(ListNode head, int k) {
//        int length = 0;
//        ListNode temp = head;
//        for (; temp != null; temp = temp.next, length++) ;
//        if (length == 0 || k % length == 0) {
//            return head;
//        }
//        k = k % length;
//    }
    public int getLength(ListNode head) {
        int length = 0;
        for (; head != null; head = head.next, length++) ;
        return length;
    }

    public void test() {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode result = rotateRight(head,1);

        for (; result != null; result = result.next) {
            System.out.println(result.val);
        }
    }
}
