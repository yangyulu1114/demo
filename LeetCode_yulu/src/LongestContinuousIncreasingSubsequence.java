public class LongestContinuousIncreasingSubsequence {
    //要注意特殊案例，一直是increasing的，比如[1,3,5,7]
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1, count = 1, len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }
}
