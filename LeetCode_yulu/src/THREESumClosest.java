import java.util.Arrays;

public class THREESumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, ans = target;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                int d = Math.abs(target - sum);
                if (d < diff) {
                    diff = d;
                    ans = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }


}
