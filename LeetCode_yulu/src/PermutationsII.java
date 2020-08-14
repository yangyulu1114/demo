import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, ans, 0);
        return ans;
    }

    public void permute(int[] nums, List<List<Integer>> ans, int start) {
        if (start >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            ans.add(list);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, start, i);;
                permute(nums, ans, start + 1);
                swap(nums, start, i);
            }

        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void test() {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> ans = permuteUnique(nums);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
