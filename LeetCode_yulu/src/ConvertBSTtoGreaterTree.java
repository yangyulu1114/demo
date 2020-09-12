//可以再看一下另一种方法Reverse Morris In-order Traversal
public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        getSumofNodes(root, sum);
        inOrderTrasverse(root, sum);
        return root;
    }

    public void inOrderTrasverse(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }
        inOrderTrasverse(root.left, sum);
        sum[0] -= root.val;
        root.val += sum[0];
        inOrderTrasverse(root.right, sum);
    }

    public void getSumofNodes(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }
        sum[0] += root.val;
        getSumofNodes(root.left, sum);
        getSumofNodes(root.right, sum);
    }

    //第二种方法在第一种方法（中序遍历）的基础上改为先遍历右子树，再遍历根节点，再遍历左子树，这样便是倒序的，这样不用先求出整个树的和，
    //可以在遍历的过程中求和并修改树的节点，可以省去一次遍历操作
    public TreeNode convertBST2(TreeNode root) {
        int[] sum = new int[1];
        Traverse(root, sum);
        return root;
    }

    public void Traverse(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }
        Traverse(root.right, sum);
        int temp = root.val;
        root.val += sum[0];
        sum[0] += temp;
        Traverse(root.left, sum);
    }
}
