import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputisaBST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        for (int i = 0, j = list.size() - 1; i < j;) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public void inOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
    }
}
