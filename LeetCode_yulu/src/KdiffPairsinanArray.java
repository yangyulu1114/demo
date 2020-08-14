import java.util.Arrays;

public class KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        int[] pair = new int[2];
        Arrays.sort(nums);
        for (int i = 0, j = 1; j < nums.length; ) {
            if (i == j) {  //i 和j必须是不同的数
                j++;
                continue;
            }
            //这里有一个很关键的点，重复的对不能重复计算，例如[2,2,3,3,4,4,5,5], 1 结果应该是3（2，3），（3，4），（4，5）
            if ((nums[j] - nums[i] == k) && (count == 0 || (count > 0 && nums[i] != pair[0] && nums[j] != pair[1]))) {
                count++;
                pair[0] = nums[i];
                pair[1] = nums[j];
                i++;
                j++;
            } else if (nums[j] - nums[i] > k){
                i++;
            } else {
                j++;
            }
        }
        return count;
    }
}
