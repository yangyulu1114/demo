import java.util.Stack;

public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            left = root.left.val;
        } else {
            left = sumOfLeftLeaves(root.left);
        }

        return left + sumOfLeftLeaves(root.right);
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        int sum = 0;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.left != null && root.left.left == null && root.left.right == null) {
                    sum += root.left.val;
                }

                root = root.right;
            }
        }
        return sum;
    }

    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sumOfLeftLeaves2(root));
    }
}
