public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (; index < nums.length; nums[index++] = 0);  //本方法不能忘了将最后的几个数组单元赋值为0
    }

   //这种方法能减少对数组的操作，如果数组中大多数元素都是0时，这种方法能好很多，因为0都被交换到后面去了，后面不用再像上面的方法一样把结尾填成0了
    public void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, index++, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void test() {
        int[] input = new int[]{0,1,0,3,12};
        moveZeroes(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}
