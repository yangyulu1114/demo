public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slowrunner = head, fastrunner = head;

        do {
            if (fastrunner == null) {
                return null;
            }
            fastrunner = fastrunner.next == null ? null : fastrunner.next.next;
            slowrunner = slowrunner.next;
        } while (fastrunner != slowrunner);

//        这种do while 写法要注意edge case 是[1] , -1时，第一次走到while就退出了，但是fastrunner也是为Null，但不能退出，所以要在第二个循环这里判断一下
//        edge case[0,1],0
        for (slowrunner = head; fastrunner != null && slowrunner != fastrunner; slowrunner = slowrunner.next, fastrunner = fastrunner.next);
        return fastrunner;
    }
}
