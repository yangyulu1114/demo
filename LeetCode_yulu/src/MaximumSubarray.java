public class MaximumSubarray {

    // dp[i] = Max(dp[i - 1] + nums[i], nums[i])
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i] + (i > 0 ? Math.max(dp[i - 1], 0) : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
    //    int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + (i > 0 ? Math.max(sum, 0) : 0);
            max = Math.max(max, sum);
        }
        return max;
    }

    public void test() {
        int value = maxSubArray2(new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        });
        System.out.println(value);
    }
}
