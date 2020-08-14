//本题要注意的几个问题1、first,second,third要先赋值一个nums中不存在的数，first,second, third三个数因为要不同，所以当num[i]与任意一个数
//相等时，该次循环不操作，否则可能会出现重复的数字 ，另外还要注意类型转换，防止溢出
//注意边界情况
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long first = (long) (Integer.MIN_VALUE) - 1, second = first, third = first;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == first || nums[i] == second || nums[i] == third) {
                continue;
            }
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third) {
                third = nums[i];
            }
        }
        return (third == (long)(Integer.MIN_VALUE) - 1) ? (int) first : (int) third;
    }

    public void test() {
        int[] input = new int[]{3, 2, 1};
        System.out.println(thirdMax(input));
    }
}
