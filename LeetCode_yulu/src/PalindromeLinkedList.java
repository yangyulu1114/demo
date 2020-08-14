public class PalindromeLinkedList {
//    public boolean isPalindrome2(ListNode head) {
//        int length = 0;
//
//        while (head != null) {
//            length ++;
//        }
//
//        ListNode dummy = new ListNode(0);
//        ListNode p =head;
//
//        for (int i = 1; i <= length /2; i ++) {
//            System.out.println(true);
//            ListNode next = p.next;
//            p.next = dummy.next;
//            dummy.next = p;
//            p = next;
//        }
//
//        ListNode firstHead = dummy.next;
//
//       while (head != null) {
//           if (firstHead.val != head.val) {
//               return false;
//           }
//           head = head.next;
//           firstHead = firstHead.next;
//       }
//
//
//        return true;
//    }

    public boolean isPalindrome(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next, length++) ;
        ListNode cur = head, dummy = new ListNode(0);
        for (int count = 1; count <= length / 2 ; count++) { //要注意count 的选择会影响后面cur的值
            ListNode temp = cur.next;
            cur.next = dummy.next; //这里要记住要先做cur.next = dummy.next 再做dummy.next = cur，不然就会变成自己的next还是自己了
            dummy.next = cur;
            cur = temp;
        }
        ListNode head2 = (length % 2 == 0) ? cur : cur.next;

        for (ListNode head1 = dummy.next; head1 != null && head2 != null; head1 = head1.next, head2 = head2.next) {
            if (head1.val != head2.val) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l1node2 = new ListNode(2);
        ListNode l1node3 = new ListNode(2);
        ListNode l1node4 = new ListNode(1);
//        ListNode l1node5 = new ListNode(1);

        l1.next = l1node2;
        l1node2.next = l1node3;
        l1node3.next = l1node4;
//        l1node4.next = l1node5;
//        l1node5.next = null;

        System.out.println(isPalindrome(l1));

    }
}
