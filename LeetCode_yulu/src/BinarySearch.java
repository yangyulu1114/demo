public class BinarySearch {
    public int search(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i <= j;) {
            int middle = (i + j) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                j = middle - 1;
            } else {
                i = middle + 1;
            }
        }
        return -1;
    }
}
