public class SameTree {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        TreeNode p_left = p, p_right = p, q_left = q, q_right = q;
//
//        while ((p_left != null && q_left != null) || (p_right != null && q_right != null)) {
//            if (p_left!= null && q_left != null) {
//                if (p_left.val != q_left.val) {
//                    return false;
//                }
//            }
//            if (p_right != null && q_right != null) {
//                if (p_right.val != q_right.val) {
//                    return false;
//                }
//            }
//            p_left = p_left != null ? p_left.left : null;
//            p_right = p_right != null ? p_right.right : null;
//            q_left = q_left != null ? q_left.left : null;
//            q_right = q_right != null ? q_right.right : null;
//        }
//
//        return p_left == null && q_left == null && p_right == null && q_right == null;
//    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public void test() {
        TreeNode head1 = new TreeNode(10);
        head1.left = new TreeNode(5);
        head1.right = new TreeNode(15);

        TreeNode head2 = new TreeNode(10);
        head2.left = new TreeNode(5);
        head2.left.right = new TreeNode(15);

        System.out.println(isSameTree(head1, head2));
    }
}
