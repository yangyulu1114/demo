public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int length = 1, index = 1, pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                length++;
                nums[index++] = nums[i];
            }
            pre = nums[i];
        }

        return length;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    public void test() {
        int[] nums = new int[] {1,2};
        int length = removeDuplicates(nums);

        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }

    }

}
