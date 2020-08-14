import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Traverse(root, list);
        TreeNode dummy = new TreeNode(0), cur = dummy;
        for (TreeNode node : list) {
            cur.left = null;
            cur.right = node;
            cur = node;
        }
        cur.left = null;
        cur.right = null;
        return dummy.right;
    }

    public void Traverse(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        Traverse(root.left, list);
        list.add(root);
        Traverse(root.right, list);
    }
}
