import java.util.*;

public class BinaryTreeRightSideView {
    //bfs,找到每一层最右边的节点
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>(), q2 = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            ans.add(q.peek().val);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.right != null) {
                    q2.offer(node.right);
                }
                if (node.left != null) {
                    q2.offer(node.left);
                }
            }
            Queue<TreeNode> temp = q;
            q = q2;
            q2 = temp;
        }
        return ans;
    }

    //dfs，找到每个深度第一次出现的那个节点，每次先遍历右边的
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Traverse(root, map, ans, 0);
        return ans;
    }

    public void Traverse(TreeNode root, HashMap<Integer, TreeNode> map, List<Integer> list, int depth) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(depth)) {
            map.put(depth, root);
            list.add(root.val);
        }
        Traverse(root.right, map, list, depth + 1);
        Traverse(root.left, map, list, depth + 1);
    }
}
