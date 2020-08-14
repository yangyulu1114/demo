public class RangeSumofBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0 ;
        }
        int sum = 0;
        if (root.val >= L && root.val <= R) {
            sum += root.val;
            sum += rangeSumBST(root.left, L, R);
            sum += rangeSumBST(root.right, L, R);
        } else if (root.val < L) {
            sum += rangeSumBST(root.right, L, R);
        } else {
            sum += rangeSumBST(root.left, L, R);
        }
        return sum;
    }

    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) {
            return 0 ;
        }
        int sum = 0;
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        if (root.val >= L) {
            sum += rangeSumBST(root.left, L, R);
        }
        if (root.val <= R) {
            sum += rangeSumBST(root.right, L, R);
        }
        return sum;
    }
}
