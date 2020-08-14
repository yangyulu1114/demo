public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0, len = nums.length, left = 0;
        for (int i = 0; i < len; sum += nums[i], i++);
        for (int i = 0; i < len; i++) {
            if (left == sum - left - nums[i]) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
