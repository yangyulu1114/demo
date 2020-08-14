public class ReorderList {
    public void reorderList(ListNode head) {
        int len = 0;
        for (ListNode node = head; node != null; len++, node = node.next);
        int[] nums = new int[len];
        int i = 0;
        for (ListNode node = head; node != null; nums[i++] = node.val, node = node.next);
        ListNode node = head;
        int m = 0, n = len - 1;
        for (; m < n;) {
            node.val = nums[m++];
            node = node.next;
            node.val = nums[n--];
            node = node.next;
        }
        if (m == n) {
            node.val = nums[m];
        }
    }

    //这种方法分三个步骤
    //1、找到中间点，将链表分层两个部分
    //2、逆转第二部分
    //3、将两个链表交叉合并起来
    public void reorderList2(ListNode head) {
        if (head == null) {   //edge case :head == null要提前排除
            return;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null, current = slow;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        ListNode first = head, second = pre;
        while (second.next != null) {  //循环的退出条件必须是second.next != null而不是second != null
            ListNode temp = first.next;
            first.next = second;
            first = temp;
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
