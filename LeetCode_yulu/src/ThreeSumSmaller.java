import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum >= target) {
                    k--;
                } else {
                    count += k - j;  //1, 2, 3, 4, 5 注意这5个数要加起来小于5的组合有几个，当j走到index = 0，k走到index = 3时，发现满足条件，这时候k的index设为1,2,3都是满足条件的，所以count += k -j,然后再移动j
                    j++;
                }
            }
        }
        return count;
    }
}
