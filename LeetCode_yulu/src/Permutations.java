import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(ans, nums, 0);
        return ans;
    }

    public void permute(List<List<Integer>> ans, int[] nums, int start) {
        if (start >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            ans.add(list);
        }

        for(int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute(ans, nums, start + 1);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public void test() {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ans = permute(nums);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
