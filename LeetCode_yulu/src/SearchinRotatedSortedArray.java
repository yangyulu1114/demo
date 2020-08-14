public class SearchinRotatedSortedArray {

    // 1 (1,x)   done
    // [1,2] (1,2,0,3)  done
    // [2,1] (1,2,0,3)
    public int search2(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            int middle = (i + j) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] >= nums[i]) {
                if (target >= nums[i] && target < nums[middle]) {
                    j = middle - 1;
                } else {
                    i = middle + 1;
                }
            } else {
                if (target > nums[middle] && target <= nums[j]) {
                    i = middle + 1;
                } else {
                    j = middle - 1;
                }
            }
        }
        return -1;
    }



    public int search(int[] nums, int target) {
        int i = 0, j = nums.length -1;

        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] >= nums[i]) {
                if (nums[middle] > target) {
                    if (nums[i] > target) {
                        i = middle + 1;
                    } else {
                        j = middle - 1;
                    }
                } else {
                    i = middle + 1;
                }
            } else {
                if (nums[middle] > target) {
                    j = middle - 1;
                } else {
                    if (nums[j] < target) {
                        j = middle - 1;
                    } else {
                        i = middle + 1;
                    }
                }
            }
        }
        return -1;
    }

    public void test() {
        int[] nums = new int[]{4,5,6,7,8,1,2,3};
        System.out.println(search(nums, 8));
    }
}
