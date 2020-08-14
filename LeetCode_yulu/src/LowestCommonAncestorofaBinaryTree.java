import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

//第三种方法再熟悉一下

public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] ans = new TreeNode[1];
        backTrack(root, p, q, ans);
        return ans[0];
    }

    public boolean backTrack (TreeNode root, TreeNode p, TreeNode q, TreeNode[] ans) {
        if (root == null) {
            return false;
        }

        int left = backTrack(root.left, p, q, ans) ? 1 : 0;
        int right = backTrack(root.right, p, q, ans) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) {  //代表两个节点都找到了
            ans[0] = root;
        }
        return left + right + mid > 0;  //代表某一个节点找到了
    }

    //这种方法是建立一个父节点的map，然后从p到q回退，找到重合的那个父节点
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        parentMap.put(root, null);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            root = stack.pop();
            if (root.left != null) {
                parentMap.put(root.left, root);
                stack.push(root.left);
            }
            if (root.right != null) {
                parentMap.put(root.right, root);
                stack.push(root.right);
            }
        }
        HashSet<TreeNode> parentSet = new HashSet<>();
        while (p != null) {
            parentSet.add(p);
            p = parentMap.get(p);
        }
        while (!parentSet.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }
}
