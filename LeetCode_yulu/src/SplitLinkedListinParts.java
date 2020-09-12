public class SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        for (ListNode temp = root; temp != null; temp = temp.next,length++) ;
        ListNode[] result = new ListNode[k];
        int number = length / k, tail = length % k, count = 1, index = 0;
        //注意空指针
        for (ListNode temp = root; temp != null && count <= (number + 1 )* tail; count++) {
            if (count % (number + 1) == 0) {
                result[index++] = root;
                root = temp.next;
                temp.next = null;
                temp = root;
            } else {
                temp = temp.next;
            }
        }
        count = 1;
        //注意number
        for (ListNode temp = root; temp != null && number != 0; count++) {
            if (count % number == 0) {
                result[index++] = root;
                root = temp.next;
                temp.next = null;
                temp = root;
            } else {
                temp = temp.next;
            }
        }
        return result;
    }

    public ListNode[] splitListToParts2(ListNode root, int k) {
        int length = 0;
        for (ListNode temp = root; temp != null; temp = temp.next,length++) ;
        ListNode[] result = new ListNode[k];
        int number = length / k, tail = length % k, count = 1, index = 0, first_part = (number + 1) * tail;
        for (ListNode temp = root; temp != null; count++) {
            if ((count <= first_part && count % (number + 1) == 0) || (count > first_part && (count - first_part) % number == 0)) {
                result[index++] = root;
                root = temp.next;
                temp.next = null;
                temp = root;
            } else {
                temp = temp.next;
            }
        }
        return result;
    }

    public void test() {
        int[] number = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode dummy = new ListNode(0), temp = dummy;
        for (int i = 0; i < number.length; i++) {
            ListNode node = new ListNode(number[i]);
            temp.next = node;
            temp = node;
        }

        ListNode[] result = splitListToParts2(dummy.next, 3);

        for (int i = 0; i < result.length; i++) {
            System.out.println(" hello    ");
            ListNode head = result[i];
            for (ListNode node = head; node != null; node = node.next) {
                System.out.println(node.val);
            }
        }
    }
}
