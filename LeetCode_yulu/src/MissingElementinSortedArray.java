public class MissingElementinSortedArray {
    //要注意答案在数组最后一个元素之后的案例，例如case ： A = [1,2,4], K = 3
    public int missingElement(int[] nums, int k) {
        int count = 0, len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int missnum = nums[i + 1] - nums[i] - 1;
            if (count + missnum < k) {
                count += missnum;
            } else {
                return nums[i] + k - count;
            }
        }
        return nums[len - 1] + k - count;
    }
    //通过这个函数能找到nums中每个Index下的missingitem数量
    public int missingItem(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }

    //利用二分查找，找到一个Index 使得missingItem[index - 1]< k <= missingTtem[index]
    public int missingElement2(int[] nums, int k) {
        int len = nums.length;
        if (missingItem(nums, len - 1) < k) {
            return nums[len - 1] + k - missingItem(nums, len - 1);
        }
        int start = 0, end = len - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (missingItem(nums, mid) < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[end] + k - missingItem(nums, end);
    }
}

