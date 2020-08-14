public class HouseRobber {
    public int rob(int[] nums) {
//       这里的max 不能设为Integer.MIN_VALUE,因为可能为空数组，这时候应该返回0
        int max = 0;
        int[] money = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                money[i] = nums[i];
            } else if (i == 1) {
                money[i] = Math.max(nums[0], nums[1]);
            } else {
                money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
            }
            max = Math.max(max, money[i]);
        }
        return max;
    }

    public int rob2(int[] nums) {
       int max = 0, pre2 = 0, pre1 = 0;
       for (int i = 0; i < nums.length; i++) {
           int money = Math.max(pre2 + nums[i], pre1);
           max = Math.max(max, money);
           pre2 = pre1;
           pre1 = money;
       }
       return max;
    }

    public void test() {
        int[] input = new int[] {2,7,9,3,1};
        System.out.println(rob2(input));
    }
}
