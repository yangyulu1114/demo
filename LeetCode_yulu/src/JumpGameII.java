public class JumpGameII {
    //动态规划
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            steps[i] = i;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }
        return steps[nums.length - 1];
    }

    public int jump2(int[] nums) {
        int jumps = 0, longestjump = 0, maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (longestjump < i) {
                longestjump = maxJump;
                jumps++;
            }
            maxJump = Math.max(maxJump, nums[i] + i);
        }
        return jumps;
    }

    public void test() {
        int[] input = new int[]{2,3,1,1,4};
        System.out.println(jump2(input));
    }
}
