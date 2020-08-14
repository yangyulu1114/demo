import java.util.TreeSet;

public class SecondMinimumNodeInaBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        TreeNode left = root.left, right = root.right;
        if (left == null || left.val == right.val) {
            return -1;
        }
        TreeNode small = root.val == left.val ? left : right;
        TreeNode large = root.val == left.val ? right : left;
        int value = findnextLargeValue(small, root.val);
        return value == -1 ? large.val : Math.min(value, large.val);
    }
    public int findnextLargeValue(TreeNode root, int value) {
        if (root == null) {
            return  -1;
        }
        if (root.val > value) {
            return root.val;
        }
        int left = findnextLargeValue(root.left, value);
        int right = findnextLargeValue(root.right, value);
        if (left == -1 && right == -1) {
            return -1;
        }
        if (left == -1 || right == -1) {
            return Math.max(left, right);
        }
        return Math.min(left, right);
    }
}
