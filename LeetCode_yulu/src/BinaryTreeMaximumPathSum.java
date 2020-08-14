public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxsum = new int[]{Integer.MIN_VALUE};
        maxGain(root, maxsum);
        return maxsum[0];
    }

    public int maxGain(TreeNode root, int[] maxsum) {
        if (root == null) {
            return 0;
        }
        int left_gain = Math.max(maxGain(root.left, maxsum), 0);
        int right_gain = Math.max(maxGain(root.right, maxsum), 0);

        maxsum[0] = Math.max(maxsum[0], root.val + left_gain + right_gain);
        return root.val + Math.max(left_gain, right_gain);
    }
}
