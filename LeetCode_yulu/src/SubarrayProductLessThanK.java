public class SubarrayProductLessThanK {

    //此方法超时了
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int product = 1;
            for (int end = start; end < nums.length; end++) {
                product *= nums[end];
                if (product < k) {
                    count++;
                }
                if (product > k) {       //要防止越界，而且大于K之后也没必要遍历了，因为都是正整数
                    break;
                }
            }
        }
        return count;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        double[] presum = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            presum[i + 1] = presum[i] + Math.log(nums[i]);
        }
        double logk = Math.log(k);
        int ans = 0;
        for (int i = 0; i < presum.length -1; i++) {
            int start = i, end = presum.length - 1;
            while (start < end) {
                int middle = (start + end) / 2;
                if (presum[middle] < logk + presum[start]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
                ans += (end - i);
            }
        }
        return ans;
    }
    public void test(){
        int[] nums = new int[]{10,5,2,6};
        System.out.println(numSubarrayProductLessThanK2(nums, 100));
    }
}
