import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {
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

    public Node connet2(Node root) {
            if (root == null) {
                return root;
            }
            Node leftmost = root;
            while (leftmost != null) {
                Node current = null, temp = null;
                for (Node node = leftmost; node != null; node = node.next) {
                    if (node.left == null && node.right == null) {
                        continue;
                    }
                    if (temp == null) {
                        temp = node.left != null ? node.left : node.right;
                    }
                    if (node.left != null) {
                        if (current == null) {
                            current = node.left;
                        } else {
                            current.next = node.left;
                            current = node.left;
                        }
                    }
                    if (node.right != null) {
                        if (current == null) {
                            current = node.right;
                        } else {
                            current.next = node.right;
                            current = node.right;
                        }
                    }
                }
                leftmost = temp;
            }
        return root;
    }

    //3是2的代码优化版本
    Node leftMost, current;
    public Node connet3(Node root) {
        leftMost = root;
        while (leftMost != null) {
            Node node = leftMost;
            current = null;
            leftMost = null;
            for (; node != null; node = node.next) {
                ConnecttoCurrent(node.left);
                ConnecttoCurrent(node.right);
            }
        }
        return root;
    }

    public void ConnecttoCurrent(Node root) {
        if (root != null) {
            if (leftMost == null) {
                leftMost = root;
            }
            if (current == null) {
                current = root;
            } else {
                current.next = root;
                current = root;
            }
        }
    }


}
