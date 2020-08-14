import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrderTraverse(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) < list.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void inOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
    }

    //第二种方法就是利用BST中序遍历的有序性在遍历的过程中即返回结果
    public boolean isValidBST2(TreeNode root) {
        int[] curValue = new int[1], flag = new int[1];
        return inOrderTraverse2(root, curValue, flag);
    }

    public boolean inOrderTraverse2(TreeNode root, int[] curVaule, int[] flag) {
        if (root == null) {
            return true;
        }
        if (inOrderTraverse2(root.left, curVaule, flag) == false) {
            return false;
        }

        if (flag[0] > 0 && curVaule[0] >= root.val) {
            return false;
        }
        flag[0] = 1;
        curVaule[0] = root.val;

        if (inOrderTraverse2(root.right, curVaule, flag) == false) {
            return false;
        }
        return true;
    }

    //第三种方法是第二种方法的循环实现方式
    public boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int flag = 0, curValue = 0;
        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (flag == 1 && curValue >= stack.peek().val) {
                return false;
            }
            flag = 1;
            curNode = stack.pop();
            curValue = curNode.val;
            curNode = curNode.right;
        }
        return true;
    }


    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST3(root));
    }
}
