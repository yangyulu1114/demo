import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        return list.get(k - 1);
    }

    public void inOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
    }

    //第二种方法再看一下
//    public int kthSmallest2(TreeNode root, int k) {
//        int[] index = new int[1];
//        return inOrderTraverse(root, index, k);
//    }
//
//    public int inOrderTraverse(TreeNode root, int[] index, int k) {
//        if (root == null) {
//            return 0;
//        }
//        int left = inOrderTraverse(root.left, index, k);
//        if (index[0] == k) {
//            return left;
//        }
//        index[0]++;
//        int right = inOrderTraverse(root.right, index, k);
//        return root.val;
//    }

    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(kthSmallest(root, 3));
    }
}
