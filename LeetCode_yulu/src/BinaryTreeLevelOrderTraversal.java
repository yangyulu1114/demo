import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        if (root == null) {
            return result;
        }
        q1.add(root);
        while (!q1.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!q1.isEmpty()){
                root = q1.poll();
                list.add(root.val);
                if (root.left != null) {
                    q2.add(root.left);
                }
                if (root.right != null) {
                    q2.add(root.right);
                }
            }
            result.add(list);
            Queue<TreeNode> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        return result;
    }
}
