import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
// dp[i] 表示递增序列中必须包含第i个元素的递增序列的长度
// [10, 9, 2, 5, 3, 7, 1, 2, 3, 4, 5, 6, 7]
// dp[0] = 1, dp[1] = 1, dp[2] = 1, dp[3] = 1+1 = 2, dp[4] = 1+1 = 2, dp[5]=2+1=3, dp[6]=1,
// dp[7] = 1+1 = 2, dp[8]= 2+1 = 3 dp[9] = 3+1 = 4, dp[10] = 4+1=5, dp[11]= 5+1 = 6
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
// dp[i]最少也为1
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
//dp[i]的公式为，nums[i]和前面的i-1个数中的每一个去比，dp[i]应该为比nums[i]小的这些数中dp[j]最大值+1；
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
