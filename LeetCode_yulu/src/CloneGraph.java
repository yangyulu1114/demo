import java.util.*;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private HashMap<Node, Node> map = new HashMap<>();

    //深度遍历
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        map.put(node, cloneNode);

        for (Node node1 : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(node1));
        }
        return node;
    }
//广度遍历
    public Node cloneGraph2(Node node) {
       if (node == null) {
            return node;
        }
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>()));
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (Node neighbor : n.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
