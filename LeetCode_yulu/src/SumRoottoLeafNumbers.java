import java.util.ArrayDeque;
import java.util.Deque;

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int[] ans = new int[1];
        sum(root, ans, 0);
        return ans[0];
    }

    public void sum(TreeNode root, int[] ans, int num) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans[0] += num * 10 + root.val;
            return;
        }

        sum(root.left, ans, num * 10 + root.val);
        sum(root.right, ans, num * 10 + root.val);
    }
// 用栈实现的前序遍历
    public int sumNumbers2(TreeNode root) {
        int num = 0, sum = 0;
//        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            root = pair.getKey();
            num = pair.getValue();

            if (root != null) {
                num = num * 10 + root.val;
                if (root.left == null && root.right == null) {
                    sum += num;
                } else {
                    stack.push(new Pair<>(root.right, num));
                    stack.push(new Pair<>(root.left, num));
                }
            }
        }
        return sum;
    }
//Moris 前序遍历
    public int sumNumbers3(TreeNode root) {
        int num = 0, sum = 0, steps;
        TreeNode predecessor;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                steps = 1;
                while (predecessor.right != null && predecessor.right != root) {
                    steps++;
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    num = num * 10 + root.val;
                    predecessor.right = root;
                    root = root.left;
                } else {
                    if (predecessor.left == null) {
                        sum += num;
                    }
                    for (int i = 0; i < steps; i++) {
                        num /= 10;
                    }
                    predecessor.right = null;
                    root = root.right;
                }

            } else {
                num = num * 10 + root.val;
                if (root.right == null) {
                    sum += num;
                }
                root = root.right;
            }
        }
        return sum;
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
    }
}
