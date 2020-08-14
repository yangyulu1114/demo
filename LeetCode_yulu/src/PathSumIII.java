public class PathSumIII {

//    文田写的还有一种方法再看下
    public int pathSum(TreeNode root, int sum) {
        int[] count = new int[1];
        helperSum(root, sum, count);
        return count[0];
    }

    public void helperSum(TreeNode root, int sum, int[] count) {
        if (root == null) {
            return;
        }

        helper(root, sum, count);

        helperSum(root.left, sum, count);
        helperSum(root.right, sum, count); //这里要注意一下
    }

    public void helper(TreeNode root, int sum, int[] count) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            count[0]++;
        }
        helper(root.left, sum - root.val, count);
        helper(root.right, sum - root.val, count);
    }
}
