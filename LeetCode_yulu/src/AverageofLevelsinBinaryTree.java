import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty()) {
            double sum = 0, count = 0;
            while (!q1.isEmpty()) {
                TreeNode node = q1.poll();
                sum += node.val;
                count++;
                if (node.left != null) {
                    q2.add(node.left);
                }
                if (node.right != null) {
                    q2.add(node.right);
                }
            }
            list.add(sum / count);
            Queue<TreeNode> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        return list;
    }

    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> list = new ArrayList<>(), count = new ArrayList<>();
        Traverse(root, list, count, 0);
        for (int i = 0; i < list.size(); list.set(i, list.get(i) / count.get(i)), i++);
        return list;
    }

    public void Traverse(TreeNode root, List<Double> sum, List<Double> count, int level) {
        if (root == null) {
            return;
        }
        if (sum.size() <= level) {
            sum.add(0.0);
        }
        if (count.size() <= level) {
            count.add(0.0);
        }
        sum.set(level, sum.get(level) + root.val);
        count.set(level, count.get(level) + 1);
        Traverse(root.left, sum, count, level + 1);
        Traverse(root.right, sum, count, level + 1);
    }

    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List list = averageOfLevels2(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
