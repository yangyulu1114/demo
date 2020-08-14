import java.util.LinkedList;
import java.util.List;

//本题注意root为null时返回的应该是空链表而不是null， 另外addString 函数里面的StringBuilder要保存一个StringBuild，后面又要改变它，那就创建它的拷贝
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if (root != null) {
            addString(list, root, new StringBuilder().append(root.val));
        }
        return list;
    }

    public void addString(List<String> list, TreeNode root, StringBuilder s) {
        if (root.left == null && root.right == null) {
            list.add(s.toString());
            return;
        }
        if (root.left != null) {
            StringBuilder left = new StringBuilder().append(s);
            left.append("->").append(root.left.val);
            addString(list, root.left, left);
        }
        if (root.right != null) {
            StringBuilder right = new StringBuilder().append(s);
            right.append("->").append(root.right.val);
            s.append(root.right.val);
            addString(list, root.right, right);
        }
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> list = binaryTreePaths(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
