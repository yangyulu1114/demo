public class CountCompleteTreeNodes {
    //时间复杂度O(N)
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

    //方法二是利用完全二叉树除了最后一层，每一层都有2的N次方个节点的特征，且最后一层所有结点都在左侧。时间复杂度是O（d^2），d为树的深度
    //计算出树的深度d,除最后一层外所有节点数为2^d - 1；最后一层的节点数大于等于1，小于等于2^d
    //将最后一层的节点从0到2^d - 1进行编码，利用二分查找看最后一层有多少个节点。
    //总节点数为2^d - 1 + 最后一层的节点
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = depth(root);
        if (depth == 0) {
            return 1;
        }
        int left = 1, right = (int) (Math.pow(2, depth) - 1); //left等于1而不是0，是因为最后一层至少有一个节点，所以0一定存在，现在应该是从1开始看是否存在
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isExist(root, mid, depth)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) (Math.pow(2, depth) - 1 + left);
    }

    public int depth(TreeNode root) {
        int depth = 0;
        while (root.left != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    public boolean isExist(TreeNode root, int index, int depth) {
        int left = 0, right = (int) Math.pow(2, depth) - 1;

        for (int i = 0; i < depth; i++) {
            int mid = (left + right) / 2;
            if (index <= mid) {  //当index <= mid时说明是在左子树，因为不管是有奇数还是偶数个节点，左边子树节点数肯定大于等于右子树节点，Mid肯定是在左侧
                right = mid;
                root = root.left;
            } else {
                left = mid + 1;
                root = root.right;
            }
        }
        return root != null;
    }
}
