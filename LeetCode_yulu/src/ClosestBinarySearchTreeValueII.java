import java.util.*;

//follow up，当是平衡二叉树时，件preStack和postStack只需要O(logN)的时间，可以再看一下
public class ClosestBinarySearchTreeValueII {
    //遍历的时候同时找，用堆，时间复杂度是O（NlogK）
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>(),ans = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? 1 : -1;
            }
        });
        traverse(root, list);
        for (int n : list) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (queue.size() > 0) {
            ans.add(queue.poll());
        }
        return ans;
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
//这种方法是将树分成两个栈，一边是比target小的，一边是比target大的，然后从中间开始到两边找，找到K个为止。时间复杂度是O(N + K)
    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        Stack<Integer> preStack = new Stack<>();
        Stack<Integer> postStack = new Stack<>();
        inOrderTraverse(root, preStack, target, true);
        inOrderTraverse(root, postStack, target, false);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (preStack.isEmpty()) {
                ans.add(postStack.pop());
            } else if (postStack.isEmpty()) {
                ans.add(preStack.pop());
            } else if (Math.abs(postStack.peek() - target) < Math.abs(preStack.peek() - target)) {
                ans.add(postStack.pop());
            } else {
                ans.add(preStack.pop());
            }
        }
        return ans;
    }

   public void inOrderTraverse(TreeNode root, Stack<Integer> stack0, double target, boolean pre) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = pre ? root.left : root.right;
            } else {
                root = stack.pop();
                if (pre && root.val > target || (!pre && root.val <= target)) { //当是要找小的数，而当前又比target大时，就不用再找右边的了，反过来当是要找大的数，而当前又比target小或相等时，就没必要找左边的了
                    return;
                }
                stack0.push(root.val);
                root = pre ? root.right : root.left;
            }
        }
   }


}
