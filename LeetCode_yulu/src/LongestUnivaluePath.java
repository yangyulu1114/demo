import java.util.ArrayList;
import java.util.List;

public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        maxUniValuePath(root, root.val, list);
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        return max - 1;
    }

    public int maxUniValuePath(TreeNode root,int val, List<Integer> list) {
        if (root == null) {
            return 0;
        }
        int left = maxUniValuePath(root.left, root.val, list);
        int right = maxUniValuePath(root.right, root.val, list);
        list.add(1 + left + right);
        return root.val == val ? Math.max(1 + left, 1 + right) : 0;
    }

    public int longestUnivaluePath2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[1];
        maxUniValuePath(root, root.val, max);
        return max[0] - 1;
    }

    public int maxUniValuePath(TreeNode root,int val, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = maxUniValuePath(root.left, root.val, max);
        int right = maxUniValuePath(root.right, root.val, max);
        max[0] = Math.max(max[0], 1 + left + right);
        return root.val == val ? Math.max(1 + left, 1 + right) : 0;
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(longestUnivaluePath(root));
    }
}
