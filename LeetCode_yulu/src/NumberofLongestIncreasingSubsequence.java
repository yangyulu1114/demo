import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1, count = 0;
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        for (int i = 0; i < dp.length; i++) {
            count += dp[i] == max ? 1 : 0;
        }
        return count;
    }
    public void test() {
        int[] input = new int[]{1,3,5,4,7};
        System.out.println(findNumberOfLIS(input));
    }
}
