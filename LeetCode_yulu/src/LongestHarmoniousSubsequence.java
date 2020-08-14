import java.util.Arrays;
import java.util.HashMap;

public class LongestHarmoniousSubsequence {
    //注意edge case[1,1,1,1]
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = 0;
        for (Integer key : map.keySet()) {
            int nextcount = map.getOrDefault(key + 1, 0);
            if (nextcount > 0) {
                max = Math.max(max, nextcount + map.get(key));
            }
        }
        return max;
    }

    public int findLHS2(int[] nums) {
        Arrays.sort(nums);
        int max = 0, pre_count = 1;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (i > 0 && nums[i] - nums[i - 1] == 1) {
              while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                  count++;
                  i++;
              }
              max = Math.max(max, pre_count + count);
              pre_count = count;
            } else {
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                pre_count = count;
            }
        }
        return max;
    }
}
