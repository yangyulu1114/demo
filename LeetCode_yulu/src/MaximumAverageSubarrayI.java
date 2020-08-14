public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Integer.MIN_VALUE;
        for (int i = 0 ; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }

    public double findMaxAverage2(int[] nums, int k) {
        //注意这里的maxSum不能设为Integer的最小值，因为sum可能比这个最小值还小。
//        不要一开始就用double，浮点数比整型慢很多
        long sum = 0;
        int i = 0;
        for (; i < k; i++) {
            sum += nums[i];
        }
        long maxSum = sum;
        for (; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum * 1.0 / k;
    }

    public void test() {
//        int[] input = new int[]{}
    }
}
