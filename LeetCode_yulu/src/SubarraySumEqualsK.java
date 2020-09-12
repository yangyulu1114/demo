import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                  //  break; 这里的break不能要，因为后面的数加起来可能刚好等于0， 注意edge case :[0,0,0,0,0,0,0,0,0,0], 0
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        HashMap<Integer, List<Integer>> table = new HashMap<>();
        int[] map = new int[nums.length];
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map[i] = sum;
            List<Integer> list = table.getOrDefault(sum, new ArrayList<>());
            list.add(i);
            table.put(sum, list);
        }
        for (int i = map.length - 1; i >= 0; i--) {
            if (map[i] == k) {
                count++;
            }
            List<Integer> list = table.get(map[i] - k);
            if (list != null) {
                for (Integer n : list) {
                    if (n < i) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //这个题目的关键就在于要保存presum，同时要利用一个等式，即sum(i,j] = sum[0, j ] - sum[0, i];
    public int subarraySum3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public void test() {
        int[] input = new int[]{-1,-1,1};
        System.out.println(subarraySum2(input, 2));
    }
}
