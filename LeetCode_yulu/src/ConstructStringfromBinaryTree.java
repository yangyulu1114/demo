public class ConstructStringfromBinaryTree {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(t, sb, 1);
        return sb.toString();
    }

    public void preOrderTraverse(TreeNode t, StringBuilder sb, int level) {
        if (t == null) {
            return;
        }
        if (level > 1) {
            sb.append('(');
        }
        sb.append(t.val);

        if (t.left == null && t.right != null) {
            sb.append('(').append(')');
        } else if (t.left != null){
            preOrderTraverse(t.left, sb, level + 1);
        }
        if (t.right != null) {
            preOrderTraverse(t.right, sb, level + 1);
        }
        if (level > 1) {
            sb.append(')');
        }
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(tree2str(root));
    }
}
