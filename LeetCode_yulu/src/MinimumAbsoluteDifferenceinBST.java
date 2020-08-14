public class MinimumAbsoluteDifferenceinBST {
    public int getMinimumDifference(TreeNode root) {
        int[] pre = new int[1], mindiff = new int[]{Integer.MAX_VALUE};  //注意这里是找最小值，所以一开始设为最大的
        boolean[] flag = new boolean[1];
        inOrderTraverse(root, pre, mindiff, flag);
        return mindiff[0];
    }

    public void inOrderTraverse(TreeNode root, int[] pre, int[] mindiff, boolean[] flag) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, pre, mindiff, flag);
        if (flag[0]) {
            mindiff[0] = Math.min(mindiff[0], root.val - pre[0]);
        }
        flag[0] = true;
        pre[0] = root.val;
        inOrderTraverse(root.right, pre, mindiff, flag);
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(getMinimumDifference(root));
    }
}
