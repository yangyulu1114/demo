import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public void test() {
        int[] input = new int[] {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(input));
    }
}
