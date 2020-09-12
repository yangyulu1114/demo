import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>(), temp = new LinkedList<>();;
        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            queue.offerLast(root);
        }

        while (queue.size() != 0) {

            TreeNode node = queue.pollFirst();
            list.add(node.val);
            if (node.left != null) {
                temp.offerLast(node.left);
            }
            if (node.right != null) {
                temp.offerLast(node.right);
            }
            if (queue.size() == 0) {
                result.add(0,new ArrayList<>(list));
                Deque<TreeNode> q = queue;
                queue = temp;
                temp = q;
                queue.addAll(temp);
                temp.clear();
                list.clear();
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>(), temp = new LinkedList<>();;
        List<List<Integer>> result = new ArrayList();
        List<Integer> list = null;
        if (root != null) {
            queue.offerLast(root);
        }
        while (queue.size() != 0) {
            if (list == null) {
                list = new ArrayList();
            }
            TreeNode node = queue.pollFirst();
            list.add(node.val);
            if (node.left != null) {
                temp.offerLast(node.left);
            }
            if (node.right != null) {
                temp.offerLast(node.right);
            }
            if (queue.size() == 0) {
                result.add(0,list);
                Deque<TreeNode> q = queue;
                queue = temp;
                temp = q;
                queue.addAll(temp);
                temp.clear();
                list = null;
            }
        }
        return result;
    }

    public void test() {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        List<List<Integer>> list = levelOrderBottom(head);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j));
                System.out.print(' ');
            }
            System.out.println();
        }

        System.out.println("hello");
    }
}
