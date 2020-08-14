import java.util.Comparator;
import java.util.PriorityQueue;
//这题很经典，建议5种方法都搞清楚
public class MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode root : lists) {
            for (ListNode current = root; current != null; current = current.next) {
                heap.add(current);
            }
        }
        if (heap.size() == 0) {
            return null;
        }
        ListNode head = heap.poll(), current = head;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            current.next = node;
            current = node;
        }
        current.next = null;
        return head;
    }

    //上面版本的优化，时间复杂度从O(nlogn)降低到O(nlogk)
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {   //不要忘了这个判断，注意特殊案例[[]]
                heap.add(node);
            }
        }
        ListNode dummy = new ListNode(0), current = dummy;
        while (!heap.isEmpty()) {
            current.next = heap.poll();
            current = current.next;
            ListNode next = current.next;
            if (next != null) {
                heap.offer(next);
            }
        }
        return dummy.next;
    }

    public ListNode mergetTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }
        return dummy.next;
    }
//DIVIDE AND Conquere,时间复杂度为O(NLOGK)，但是因为这种方法没有一些复杂数据结构的操作，所以运算起来会快一些
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += (2 * interval)) {
                lists[i] = mergetTwoList(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
}
