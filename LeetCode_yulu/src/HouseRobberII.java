public class HouseRobberII {
    public int rob(int[] nums) {
//        要注意edge case,[], [1], [2]
        int length = nums.length;
        if (length > 2 || length == 0) {
            return Math.max(rob(nums, 0, length - 2), rob(nums, 1, length -1));
        } else {
            return length == 1 ? nums[0] : Math.max(nums[0], nums[1]);
        }
    }

    public int rob(int[] nums, int start, int end) {
        int max = 0, pre2 = 0, pre1 = 0;
        for (int i = start; i <= end ; i++) {
            int money = Math.max(pre2 + nums[i], pre1);
            max = Math.max(max, money);
            pre2 = pre1;
            pre1 = money;
        }
        return max;
    }

    public int rob2(int[] nums) {
        int length = nums.length;
        return Math.max(rob2(nums, 0, length - 2), rob2(nums, 1, length -1));
    }

    public int rob2(int[] nums, int start, int end) {
        int max = 0, pre2 = 0, pre1 = 0;
//        要注意出现end < start的情况，这样循环就走不到了
        end = end >= start ? end : start;
//        要防止数组为空时出现越界
        for (int i = start; i <= end & i < nums.length; i++) {
            int money = Math.max(pre2 + nums[i], pre1);
            max = Math.max(max, money);
            pre2 = pre1;
            pre1 = money;
        }
        return max;
    }

    public void test() {
        int[] input = new int[]{1,2};
        System.out.println(rob2(input));
    }
}
