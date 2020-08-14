import java.util.Stack;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int[] ans = new int[1];
        double[] diff = new double[]{Double.MAX_VALUE};
        traverse(root, target, ans, diff);
        return ans[0];
    }
    //时间复杂度O（N）
    public void traverse(TreeNode root, double target, int[] ans, double[] diff) {
        if (root == null) {
            return;
        }
        if (root.val == target) {
            ans[0] = root.val;
            diff[0] = 0;
            return;
        }
        if (Math.abs(root.val - target) < diff[0]) {
            ans[0] = root.val;
            diff[0] = Math.abs(root.val - target);
        }
        traverse(root.left, target, ans, diff);
        traverse(root.right, target, ans, diff);
    }

    //时间复杂度o(K)
    public int closestValue2(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE; //这里用long，是因为树里的数可能和pre很接近，用Long就不可能了

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (target >= pre && target <= root.val) {
                return Math.abs(pre - target) < Math.abs(target - root.val) ? (int) pre : root.val;  //当target在前一个数和当前数之间时，差值可能是最小的
            }
            pre = root.val;
            root = root.right;
        }
        return (int) pre;
    }

//二分查找,时间复杂度O（H），H是数的高度。如果root.val比target大，就只用在左子树查找，反之只用在右子树查找
    public int closestValue3(TreeNode root, double target) {
        int closet = root.val, current;
        while (root != null) {
            current = root.val;
            closet = Math.abs(current - target) < Math.abs(closet - target) ? current : closet;
            root = current > target ? root.left : root.right;
        }
        return closet;
    }

}
