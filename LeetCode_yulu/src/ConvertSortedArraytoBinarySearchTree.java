public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        } else {
            return arrayToBST(nums, 0, nums.length - 1);
        }
    }

    public TreeNode arrayToBST(int[] nums, int start_index, int end_index) {
        if (end_index < start_index) {
            return null;
        }
        int middle = (start_index + end_index) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = arrayToBST(nums, start_index, middle - 1);
        node.right = arrayToBST(nums, middle + 1, end_index);
        return node;
    }
}
