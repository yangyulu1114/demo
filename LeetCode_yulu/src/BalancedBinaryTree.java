public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new int[1]);
    }

    public boolean isBalanced(TreeNode root, int[] height) {
        if (root == null) {
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        boolean flag1 = isBalanced(root.left, left);
        boolean flag2 = isBalanced(root.right, right);
        height[0] = Math.max(left[0], right[0]) + 1;
        return flag1 && flag2 && Math.abs(left[0] - right[0]) <= 1;
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((!isBalanced(root.left)) || (!isBalanced(root.right))) {
            return false;
        }

        int left_depth = getTreeDepth(root.left);
        int right_depth = getTreeDepth(root.right);
        return left_depth - right_depth == 0 || left_depth - right_depth == -1 || left_depth - right_depth ==1;
    }

    public int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftdepth = getTreeDepth(root.left);
        int rightdepth = getTreeDepth(root.right);
        return leftdepth > rightdepth ? leftdepth + 1 : rightdepth + 1;
    }

    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        System.out.println(isBalanced(root));
    }
}
