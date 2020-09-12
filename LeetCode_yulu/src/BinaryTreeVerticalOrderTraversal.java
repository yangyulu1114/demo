import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    //DFA
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        Traverse(root, map, 0, 0);
        List<Map.Entry<Integer, List<Pair<Integer, Integer>>>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());
        for (Map.Entry<Integer, List<Pair<Integer, Integer>>> entry : list) {
            List<Pair<Integer, Integer>> pairs = entry.getValue();
            pairs.sort(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();
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
    // DFS without sorting, 这种方法类似于3也适用一个minColumn和一个maxColumn变量来保存key，省去了map的排序，即column的排序，但是row的排序还是需要，不过要注意，这样
    //得注意edge case，root == null,这个case要提前排除掉。
    public List<List<Integer>> verticalOrder4(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        HashMap<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        int[] minColumn = new int[1], maxColumn = new int[1];
        Traverse2(root, map, 0, 0, minColumn,maxColumn);
        for (int i = minColumn[0]; i <= maxColumn[0]; i++) {
            List<Pair<Integer, Integer>> pairs = map.get(i);
            pairs.sort(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();
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

    public void Traverse2(TreeNode root, HashMap<Integer, List<Pair<Integer, Integer>>> map, int column, int row, int[] minColumn, int[] maxColumn) {
        if (root == null) {
            return;
        }
        List<Pair<Integer, Integer>> list = map.getOrDefault(column, new ArrayList<>());
        list.add(new Pair<>(root.val, row));
        map.put(column, list);
        minColumn[0] = Math.min(minColumn[0], column);
        maxColumn[0] = Math.max(maxColumn[0], column);
        Traverse2(root.left, map, column - 1, row + 1, minColumn, maxColumn);
        Traverse2(root.right, map, column + 1, row + 1, minColumn, maxColumn);
    }

    public void Traverse(TreeNode root, HashMap<Integer, List<Pair<Integer, Integer>>> map, int column, int row) {
        if (root == null) {
            return;
        }
        List<Pair<Integer, Integer>> list = map.getOrDefault(column, new ArrayList<>());
        list.add(new Pair<>(root.val, row));
        map.put(column, list);
        Traverse(root.left, map, column - 1, row + 1);
        Traverse(root.right, map, column + 1, row + 1);
    }


//BFS
    public List<List<Integer>> verticalOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        HashMap<Integer, List<Integer>> columnMap = new HashMap<>();

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();
            List<Integer> list = columnMap.getOrDefault(column, new ArrayList<>());
            list.add(node.val);
            columnMap.put(column, list);
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, column - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, column + 1));

            }
        }
        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(columnMap.entrySet());
        list.sort(Map.Entry.comparingByKey());
        for (Map.Entry<Integer, List<Integer>> entry : list) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    //BFS without sorting.这种方法还是广度优先遍历，但是在遍历过程中找到了最小列和最大列，也就是找到了map的key，这样不用再对map进行排序
    public List<List<Integer>> verticalOrder3(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        HashMap<Integer, List<Integer>> columnMap = new HashMap<>();
        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();
            List<Integer> list = columnMap.getOrDefault(column, new ArrayList<>());
            list.add(node.val);
            columnMap.put(column, list);
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, column - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, column + 1));
            }

            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);
        }
        for (int i = minColumn; i <= maxColumn; i++) {
            ans.add(columnMap.get(i));
        }
        return ans;
    }
}
