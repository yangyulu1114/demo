import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>(), q2 = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            while (!q.isEmpty()) {
                Node node = q.poll();
                node.next = q.peek();
                if (node.left != null) {
                    q2.offer(node.left);
                }
                if (node.right != null) {
                    q2.offer(node.right);
                }
            }
            Queue<Node> temp = q;
            q = q2;
            q2 = temp;
        }
        return root;
    }

    //这种方法是在第N层时就已经处理好了N+1层的节点关系，当遍历到N+1层时，这一层的next关系已经存在，需要处理的是N+2层。
    //所以只需要记住每一层最左边的节点就好，从而降低了空间复杂度
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            for (Node node = leftmost; node != null; node = node.next) {
                node.left.next = node.right;  //每一层的next关系有两种，左边的子节点的next应该为右边的子节点，而右边子节点的next和右子节点已经不是一个parent了
                node.right.next = node.next == null ? null : node.next.left;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public void test() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connect(root);
    }
}
