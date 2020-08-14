import java.util.HashMap;

public class CopyListwithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
//另外两方法可以再看一下
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0), cur = dummy;
        HashMap<Node, Node> map = new HashMap<>();
        for (Node node = head; node != null; node = node.next) {
            Node temp = new Node(node.val);
            cur.next = temp;
            cur = temp;
            map.put(node, temp);
        }
        cur = dummy.next;
        for (Node node = head; node != null; node = node.next, cur = cur.next) {
            if (node.random != null) {
                cur.random = map.get(node.random);
            }
        }
        return dummy.next;
    }
}
