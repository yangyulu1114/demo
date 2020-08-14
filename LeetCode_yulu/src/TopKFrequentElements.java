import java.util.*;

public class TopKFrequentElements {
    //时间复杂度o(nlogn)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }));
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            ans.add(entry.getKey());
            if (ans.size() == k) {
                break;
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    //利用priorityquene创建heap，时间复杂度是O(nlogk)
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //升序排列的priorityQuene保证堆顶是最小的，且每个节点都比它的子节点要小，优先队列由完全二叉树实现，可以是自然排序，也可以传入comparator排序
        //本题根据频率排序
        PriorityQueue<Integer> queue = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer n : map.keySet()) {
            queue.offer(n);
            if (queue.size() > k) { //保证quene里留下的数是频率最高的k个数
                queue.poll();
            }
        }
        int[] ans = new int[k];
        int index = 0;
        while (!queue.isEmpty()){
            ans[index++] = queue.poll();
        }
        return ans;
    }

    //时间复杂度是o(n)
    public int[] topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            max = Math.max(max, count);
            map.put(nums[i], count);
        }
        int[] a = new int[1];
        List<Integer>[] lists = new ArrayList[max + 1];  //建一个不同频率的数组，将每个数分配到不同的频率对应的单元格中，用链表串联起来
        for (int n : map.keySet()) {
            int count = map.get(n);
            if (lists[count] == null) {
                lists[count] = new ArrayList<>();
            }
            lists[count].add(n);
        }
        int[] ans = new int[k];
        for (int i = max, index = 0; i >= 0 && index < k; i--) {
            List<Integer> list = lists[i];
            if (list != null) {
                for (int n : list) {
                    ans[index++] = n;
                }
            }
        }
        return ans;
    }

    public void test() {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] ans = topKFrequent2(nums, 2);
        for (int n : ans) {
            System.out.println(n);
        }
    }
}
