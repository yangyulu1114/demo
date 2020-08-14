public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        int[] sumtilt = new int[1];
        sumOfTree(root, sumtilt);
        return sumtilt[0];
    }

    public int sumOfTree(TreeNode root, int[] sumtilt) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfTree(root.left, sumtilt);
        int rightSum = sumOfTree(root.right, sumtilt);

        int tilt = Math.abs(leftSum - rightSum);
        sumtilt[0] += tilt;

        return leftSum + rightSum + root.val;
    }
}
