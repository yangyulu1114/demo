public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, count);
                count = 0;
            } else {
                count++;
            }
            if (i == nums.length - 1) {
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public void test() {
        int[] input = new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(input));
    }
}
