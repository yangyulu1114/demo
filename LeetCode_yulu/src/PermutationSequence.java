//另一种方法再看一下
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        for (int i = 1; i < k; i++) {
            nextPermutation(nums);
        }
        StringBuilder sb = new StringBuilder();
        for (int a : nums) {
            sb.append(a);
        }
        return sb.toString();
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int start) {
        for (int i = start,j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void test() {
        System.out.println(getPermutation(3, 3));
    }
}
