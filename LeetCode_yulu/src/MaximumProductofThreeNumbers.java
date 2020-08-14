import java.util.Arrays;

public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
//        if (nums.length == 3) {
//            return nums[0] * nums[1] * nums[2];
//        }
        int[] minimum = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] maximum = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
//        int negative = 0;
        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < 0) {
//                negative++;
//            }
            if (nums[i] < minimum[0]) {
                minimum[1] = minimum[0];
                minimum[0] = nums[i];
            } else if (nums[i] < minimum[1]) {
                minimum[1] = nums[i];
            }
            if (nums[i] > maximum[0]) {
                maximum[2] = maximum[1];
                maximum[1] = maximum[0];
                maximum[0] = nums[i];
            } else if (nums[i] > maximum[1]) {
                maximum[2] = maximum[1];
                maximum[1] = nums[i];
            } else if (nums[i] > maximum[2]) {
                maximum[2] = nums[i];
            }
        }
//        if (negative < 2) {
//            return maximum[0] * maximum[1] * maximum[2];
//        } else {
            return Math.max(minimum[0] * minimum[1] * maximum[0], maximum[0] * maximum[1] * maximum[2]);
//        }
    }

    public int maximumProduct2(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public int maximumProduct3(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }



    public void test() {
        int[] input = new int[] {-1,-2,-3,-4};
        System.out.println(maximumProduct(input));
    }
}
