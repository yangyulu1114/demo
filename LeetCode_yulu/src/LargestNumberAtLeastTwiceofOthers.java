public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max1 = 0, max2 = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max1]) {
                max2 = max1;
                max1 = i;
            } else if (max2 == -1 || nums[i] > nums[max2]) {
                max2 = i;
            }
        }
        return nums[max1] >= 2 * nums[max2] ? max1 : -1;
    }

    public int dominantIndex2(int[] nums) {
        int maxindex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxindex]) {
                maxindex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxindex && nums[i] * 2 > nums[maxindex]) {
                return -1;
            }
        }
        return maxindex;
    }
}
