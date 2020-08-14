import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>(); //只有要频繁删除时才有LinkedList,其它情况都用ArrayList
        postorder(root, list);
        return list;
    }

    public void postorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            postorder(node, list);
        }
        list.add(root.val);
    }

    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(0, root.val);
            for (int i = 0; i < root.children.size(); i++) {
                stack.push(root.children.get(i));
            }
        }
        return list;
    }
}
