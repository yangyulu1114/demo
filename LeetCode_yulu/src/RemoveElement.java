public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int length = 0, index = -1;

        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (nums[i] != val) {
                i++;
                length++;
            } else {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    length++;
                    i++;
                    j--;
                } else {
                    j--;
                }
            }

        }
        return length;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;

        for (int j = nums.length - 1; i <= j; ) {
            if (nums[i] != val) {
                i++;
            } else {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
                j--;
            }

        }
        return i;
    }

    public void test() {
        int[] nums = new int[] {0,1,2,2,3,0,4,2};
        int length = removeElement(nums,2);

        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
}
