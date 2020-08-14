import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            node.left = null;
            node.right = (i == list.size() - 1) ? null : list.get(i + 1);
        }
    }

    public void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    //这种方法是用递归的方法，和上面不同的是，在递归的过程中就把数修改了
    public void flatten2(TreeNode root) {
        recurse(root);
    }
//递归的过程分几步
//    1、假设数的左子树和右子树都已经修改好了
//    2、如果左子树村子，这时候应该讲左子树的尾巴的right设成root.right
//    3、将root.right设成左子树
//    4、将root.left设为空
//    5、返回新的尾巴，如果树本来没有右子树，那应该就返回左边子树的尾巴，如果有右子树就返回右子树的尾巴
    public TreeNode recurse(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode leftTail = recurse(root.left);
        TreeNode rightTail = recurse(root.right);
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightTail == null ? leftTail : rightTail;
    }

    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        int START = 1, END = 2;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, START));
        TreeNode tail = null;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> nodeData = stack.pop();
            TreeNode currentNode = nodeData.getKey();
            int status = nodeData.getValue();

            if (currentNode.left == null && currentNode.right == null) {
                tail = currentNode;
                continue;
            }

            if (status == START) {
                if (currentNode.left != null) {
                    stack.push(new Pair<>(currentNode, END));
                    stack.push(new Pair<>(currentNode.left, START));
                } else {
                    stack.push(new Pair<>(currentNode.right, START));
                }

            } else {
                TreeNode rightNode = currentNode.right;
                if (tail != null) {
                    tail.right = rightNode;
                    currentNode.right = currentNode.left;
                    currentNode.left = null;
                }
                if (rightNode != null) {
                    stack.push(new Pair<>(rightNode, START));
                }
            }
        }
    }

    //GREED方法，空间复杂度度降到O（1）,但是时间会增加，因为会遍历两次,node一次，leftRightMost一次
    public void flatten4(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode leftRightMost = node.left;
                while (leftRightMost.right != null) {
                    leftRightMost = leftRightMost.right;
                }
                leftRightMost.right = node.right;
                node.right = node.left;
                node.left = null;
                node = leftRightMost;
                continue;
            }
            node = node.right;
        }
    }
}
