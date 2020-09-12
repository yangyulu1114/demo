import java.util.*;

public class VerticalOrderTraversalofaBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, List<Integer>> intermediateMap = new HashMap<>();
        Queue<Pair<TreeNode,Integer>> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        int minColumn = 0, maxColumn = 0;
        q1.offer(new Pair<>(root, 0));
        while (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                Pair<TreeNode, Integer> pair = q1.poll();
                TreeNode node = pair.getKey();
                int column = pair.getValue();
                List<Integer> list = intermediateMap.getOrDefault(column, new ArrayList<>());
                list.add(node.val);
                intermediateMap.put(column, list);
                if (node.left != null) {
                    q2.offer(new Pair<>(node.left, column - 1));
                }
                if (node.right != null) {
                    q2.offer(new Pair<>(node.right, column + 1));
                }
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);
            }
            for (Map.Entry<Integer, List<Integer>> entry : intermediateMap.entrySet()) {
                List<Integer> list = entry.getValue();
                Collections.sort(list);
                List<Integer> list2 = map.getOrDefault(entry.getKey(), new ArrayList<>());
                list2.addAll(list);
                map.put(entry.getKey(), list2);
            }
            intermediateMap.clear();
            Queue<Pair<TreeNode,Integer>> temp = q2;
            q2 = q1;
            q1 = temp;
        }
        for (int i = minColumn; i <= maxColumn; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }


    public List<List<Integer>> verticalTraversal2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] minColumn = new int[1], maxColumn = new int[1];
        HashMap<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        VerticTraverse(root, map, 0, 0, minColumn, maxColumn);
        for (int i = minColumn[0]; i <= maxColumn[0]; i++) {
            List<Pair<Integer, Integer>> pairs = map.get(i);
            pairs.sort(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o1.getValue() == o2.getValue() ? o1.getKey() - o2.getKey() : o2.getValue() - o1.getValue();
                }
            });
            List<Integer> res = new ArrayList<>();
            for (Pair<Integer, Integer> pair : pairs) {
                res.add(pair.getKey());
            }
            ans.add(res);
        }
        return ans;
    }

    public void VerticTraverse(TreeNode root,  HashMap<Integer, List<Pair<Integer, Integer>>> map, int column, int row, int[] minColumn, int[] maxColumn) {
        if (root == null) {
            return;
        }
        List<Pair<Integer, Integer>> list = map.getOrDefault(column, new ArrayList<>());
        list.add(new Pair<>(root.val, row));
        map.put(column, list);
        minColumn[0] = Math.min(minColumn[0], column);
        maxColumn[0] = Math.max(maxColumn[0], column);
        VerticTraverse(root.left, map, column - 1, row - 1, minColumn, maxColumn);
        VerticTraverse(root.right, map, column + 1, row - 1, minColumn, maxColumn);
    }

    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        verticalTraversal(root);
    }
}
