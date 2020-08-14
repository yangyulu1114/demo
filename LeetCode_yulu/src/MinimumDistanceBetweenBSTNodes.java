import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        inorderTraverse(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(list.get(i + 1) - list.get(i), min);
        }
        return min;
    }

    public void inorderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left, list);
        list.add(root.val);
        inorderTraverse(root.right, list);
    }

    public int minDiffInBST2(TreeNode root) {
        int[] min = new int[]{Integer.MAX_VALUE}, pre = new int[1], flag = new int[1];
        inorderTraverse(root, pre, min, flag);
        return min[0];
    }

    public void inorderTraverse(TreeNode root, int[] pre, int[] min, int[] flag) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left, pre, min, flag);
        if (flag[0] == 1) {
            min[0] = Math.min(min[0], root.val - pre[0]);
        }
        pre[0] = root.val;
        flag[0] = 1;
        inorderTraverse(root.right, pre, min, flag);
    }
}
