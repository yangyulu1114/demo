public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int i = 0, length = nums.length;

        for (; i <= (length-1/2) && (nums[i] != target && nums[length - i - 1] != target); i++ ) {

            if (target < nums[i]) {
                return i;
            }

            if (target > nums[length - i -1]) {
                return length - i;
            }
        }

        return nums[i] == target ? i : length - i -1;
    }

    public int searchInsert2(int[] nums, int target) {
        int i = 0, j = nums.length -1;

        while (i <= j) {
            int mid = (i + j) /2;
            if (i == j && nums[mid] != target) {
                break;
            }
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid -1;
            }
        }

        return nums[i] > target? i : i + 1;
    }

    public int searchInsert3(int[] nums, int target) {
        int i = 0, j = nums.length -1;

        while (i <= j) {
            int mid = (i + j) /2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            }
        }

        return i;
    }

    public void test() {
        int[] nums = new int[] {1,3,5,6};

        System.out.println(searchInsert2(nums, 7));
    }
}
