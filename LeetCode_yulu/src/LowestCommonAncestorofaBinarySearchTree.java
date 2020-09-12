//本题可以根据Binary Search Tree的特性来做：即左子树一定小于或等于root的值，右子树一定大于或等于root的值

public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        要先搞清楚谁是小的，谁是大的，这样好区分谁是左子树，谁是右子树
        TreeNode small = p.val < q.val ? p : q;
        TreeNode large  = p.val > q.val ? p : q;

        if (small.val <= root.val && large.val >= root.val) {
            return root;
        } else if (small.val < root.val && large.val < root.val) {
            return lowestCommonAncestor(root.left, small, large);
        } else {
            return lowestCommonAncestor(root.right, small, large);
        }
    }

}
