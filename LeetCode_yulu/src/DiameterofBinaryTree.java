public class DiameterofBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] len = new int[1];
        depth(root, len);
        return len[0];
    }

    public int depth(TreeNode root, int[] len) {
        if (root == null) {
            return 0;
        }
        int leftlen = depth(root.left, len);
        int rightlen = depth(root.right, len);
        len[0] = Math.max((leftlen + rightlen), len[0]);
        return Math.max(leftlen, rightlen) + 1;
    }
}
