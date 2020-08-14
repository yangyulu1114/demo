import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//要注意查重，三次查重
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j ++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int m = j + 1, n = nums.length - 1; m < n;) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum > target) {
                        n--;
                    } else if (sum < target) {
                        m++;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        for (m++, n--; m < n && nums[m] == nums[m - 1]; m++);
                    }
                }
            }
        }
        return ans;
    }
}
