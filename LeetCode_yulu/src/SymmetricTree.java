import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            return isEqual(left.left, right.right) && isEqual(left.right, right.left);
        } else {
            return false;
        }
    }

//    public TreeNode next(Stack<TreeNode> stack) {
//
//    }
//
//    public boolean isEqual2(TreeNode left, TreeNode right) {
//
////        Stack<TreeNode> stack2 = new Stack<>();
////        while (!stack1.isEmpty() || left != null) {
////
////        }
//    }

    public List<TreeNode> preOrder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                result.add(root);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return result;
    }

    public void test() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(2);
//        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(3);
//        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(3);

        for (TreeNode node : preOrder(head)) {
            System.out.println(node.val);
        }


        System.out.println(isSymmetric(head));
    }
}
