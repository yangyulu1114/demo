public class SubtreeofAnotherTree {
    //注意edge case s:[1,1], t[1]
    //方法一就是通过递归去判断t.val = s.val，并且左子树，右子树都想得
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }

        if (s.val == t.val && isIdential(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

    }

    public boolean isIdential(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        }
        return s.val == t.val && isIdential(s.left, t.left) && isIdential(s.right, t.right);
    }
//第二种使用前序遍历之后比较的方法
    public boolean isSubTree2(TreeNode s, TreeNode t) {
        String sb1 = preOrder(s, true).toString();
        String sb2 = preOrder(t, false).toString();
        return sb1.indexOf(sb2) >= 0;
    }

    public StringBuilder preOrder(TreeNode root, boolean left) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            if (left) {
                sb.append("lnull");
            } else {
                sb.append("rnull");
            }
        } else {
            //一定要带上这个#号，因为可能会出现[12][2]这种案例
            sb.append("#").append(root.val).append(preOrder(root.left, true)).append(preOrder(root.right, false));
        }
        return sb;
    }
    public void test() {
        TreeNode s = new TreeNode(12);
        TreeNode t = new TreeNode(2);
        System.out.println(isSubTree2(s,t));
    }
}
