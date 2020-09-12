import java.util.*;

public class FindModeinBinarySearchTree {
    //时间复杂度是o(nlgn)，因为要排序，空间复杂度是o(n)
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        constructMap(map, root);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }));

        List<Integer> result = new LinkedList<>();
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : list) {
            int temp = entry.getValue();
            if (temp >= max) {
                max = temp;
                result.add(entry.getKey());
            } else {
                break;
            }
        }
        int[] modes = new int[result.size()];
        for(int i = 0; i < result.size(); modes[i] = result.get(i), i++);
        return modes;
    }

    public void constructMap(HashMap<Integer, Integer> map, TreeNode root){
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        constructMap(map, root.left);
        constructMap(map, root.right);
    }
    //第二种方法是利用BST中序遍历的有效性在遍历的过程中就统计次数，建立list，从而免掉排序，时间复杂度为o(n)

    public int[] findMode2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        int[] maxCount = new int[1], curCount = new int[1], curValue = new int[1], flag = new int[1];

        inorderTravese(list, root, maxCount, curCount, curValue, flag);

        int[] modes = new int[list.size()];
        for (int i = 0; i < list.size(); modes[i] = list.get(i), i++);
        return modes;
    }

    public void inorderTravese(List<Integer> list, TreeNode root, int[] maxCount, int[] curCount, int[] CurValue, int[] flag){
        if (root == null) {
            return;
        }

        inorderTravese(list, root.left, maxCount, curCount, CurValue, flag);

        if (flag[0] != 0 && root.val != CurValue[0]) {
            curCount[0] = 1;
        } else {
            curCount[0]++;
        }
        flag[0] = 1;
//        if (CurValue.length == 0) {  //这样是不行的，要注意递归的传递和执行顺序，curValue刚开始传进来为空，递归到底部才new,返回到上面的时候还是那个为空的curValue.
//            CurValue = new int[1];
//        }
        CurValue[0] = root.val;

        if (curCount[0] > maxCount[0]) {
            list.clear();
            list.add(root.val);
            maxCount[0] = curCount[0];
        } else if (curCount[0] == maxCount[0]) {
            list.add(root.val);
        }

        inorderTravese(list, root.right, maxCount, curCount, CurValue, flag);
    }


    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        int[] modes = findMode2(root);
        for (int mode : modes) {
            System.out.println(mode);
        }
    }
}
