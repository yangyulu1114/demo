import java.util.HashMap;

public class ContinuousSubarraySum {
    //本题要注意k = 0的情况
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int start = 0; start < nums.length - 1; start++) {
            int sum = nums[start];
            for (int end = start + 1; end < nums.length; end++) {
                sum += nums[end];
                if (k == 0 && sum == 0) {
                    return true;
                }
                if (k != 0 && sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  //这一句特别关键，因为有一个edge case[0,0], 0
        int remainder = 0;
        for (int i = 0; i < nums.length; i++) {
            remainder += nums[i];
            if(k != 0) {
                remainder %= k;
            }
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

    public void test() {
        int[] nums = new int[]{23,2,4,6,7};
        System.out.println(checkSubarraySum2(nums, 6));
    }
}
