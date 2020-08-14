public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0], pre = nums[0], preMaxAbs = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(Math.max(nums[i], pre * nums[i]), nums[i] * preMaxAbs);
            max = Math.max(max, pre);
            preMaxAbs = preMaxAbs == 0 ? 0 : preMaxAbs * nums[i];
        }
        return max;
    }
}
