import java.util.TreeSet;

public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            } else {
                if (set.ceiling(nums[i]) != null && set.ceiling(nums[i])> nums[i]) {
                    count++;
                }
                set.add(nums[i]);
            }
        }
        return count <= 1;
    }
}
