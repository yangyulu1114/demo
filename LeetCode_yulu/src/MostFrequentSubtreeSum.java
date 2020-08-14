import java.util.*;

public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        sumOfSubTree(root, map);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }));
        List<Integer> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : list) {
            int count = entry.getValue();
            if (count >= max) {
                max = count;
                result.add(entry.getKey());
            } else {
                break;
            }
        }
        int[] frequentSum = new int[result.size()];
        for(int i = 0; i < result.size(); frequentSum[i] = result.get(i), i++);
        return frequentSum;
    }

    public int sumOfSubTree(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + sumOfSubTree(root.left, map) + sumOfSubTree(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        int[] result = findFrequentTreeSum2(root);
        for (Integer n : result) {
            System.out.println(n);
        }
    }
    //第二种方法是在第一种方法的基础上省去排序
    public int[] findFrequentTreeSum2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] max = new int[1];
        sumOfSubTree(root, map, list, max);
        int[] frequentSum = new int[list.size()];
        for(int i = 0; i < list.size(); frequentSum[i] = list.get(i), i++);
        return frequentSum;
    }

    public int sumOfSubTree(TreeNode root, HashMap<Integer, Integer> map, List<Integer> list, int[] max) {
        if (root == null) {
            return 0;
        }
        int sum = sumOfSubTree(root.left, map, list, max) + sumOfSubTree(root.right, map, list, max) + root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        if (count > max[0]) {
            list.clear();
            list.add(sum);
            max[0] = count;
        }else if (count == max[0]) {
            list.add(sum);
        }
        return sum;
    }

    public int[] findFrequentTreeSum3(TreeNode root) {
        //这里用ArrayList会比LinkedList快，一般需要频繁删除才用LinkedList
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] max = new int[1];
        sumOfSubTree(root, map, max);
        for(Integer key : map.keySet()) {
            if (map.get(key) == max[0]) {
                list.add(key);
            }
        }
        int[] frequentSum = new int[list.size()];
        for(int i = 0; i < list.size(); frequentSum[i] = list.get(i), i++);
        return frequentSum;
    }

    public int sumOfSubTree(TreeNode root, HashMap<Integer, Integer> map, int[] max) {
        if (root == null) {
            return 0;
        }
        int sum = sumOfSubTree(root.left, map, max) + sumOfSubTree(root.right, map, max) + root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        if (count > max[0]) {
            max[0] = count;
        }
        return sum;
    }
}
