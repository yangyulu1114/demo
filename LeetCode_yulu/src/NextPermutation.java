public class NextPermutation {
    //这题画图之后会比较清楚，分三个步骤
    //1.从右边开始往前遍历，找到第一个左边小于右边相邻数的点i.  2、从i右边找到比nums[i]大的最小数 3、将i右边的数reverse
    //注意一些edge case，例如[1],[3,2,1],[1,2,3]
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

    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0 && nums[i] >= nums[i + 1]; i--);
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int j = i + 1, smallNum = nums[j];
            for (int start = j; start < nums.length; start++) {
                if (nums[start] > nums[i] && nums[start] < smallNum) {
                    smallNum = nums[start];
                    j = start;
                }
            }
            swap2(nums, i, j);
            reverse(nums,i + 1, nums.length - 1);
        }
    }

    public void swap2(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        for (; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public void test() {
        int[] nums = new int[]{2,3,1,3,3};
        nextPermutation2(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }
}
