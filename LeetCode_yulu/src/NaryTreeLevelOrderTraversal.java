import java.util.*;

public class NaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> quene1 = new LinkedList<>(), quene2 = new LinkedList<>();
        if (root == null) {
            return result;
        }
        quene1.add(root);
        while (!quene1.isEmpty() || !quene2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!quene1.isEmpty()) {
                root = quene1.poll();
                list.add(root.val);
                for (int i = 0; i < root.children.size(); i++) {
                    quene2.add(root.children.get(i));
                }
            }
            result.add(list);
            Queue<Node> temp = quene1;
            quene1 = quene2;
            quene2 = temp;
        }
        return result;
    }
}
