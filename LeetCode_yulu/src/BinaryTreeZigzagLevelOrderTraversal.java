import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        if (root == null) {
            return result;
        }
        stack1.push(root);
        for (int i = 1; !stack1.isEmpty(); i++) {
            List<Integer> list = new ArrayList<>();
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                if (root == null) {
                    continue;
                }
                list.add(root.val);
                if (i % 2 != 0) {
                    stack2.push(root.left);
                    stack2.push(root.right);
                } else {
                    stack2.push(root.right);
                    stack2.push(root.left);
                }
            }
            if (list.size() > 0) {
                result.add(list);
            }
            Stack<TreeNode> temp = stack1;
            stack1 = stack2;
            stack2 = temp;
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, result, 0);
        return result;
    }

    public void traverse(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        List<Integer> list = result.get(level);
        if (level % 2 == 0) {
            list.add(root.val);
        } else {
            list.add(0, root.val);
        }
        traverse(root.left, result, level + 1);
        traverse(root.right, result, level + 1);
    }
}
