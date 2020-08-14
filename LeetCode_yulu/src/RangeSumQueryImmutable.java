
import javafx.util.Pair;

import java.util.HashMap;

public class RangeSumQueryImmutable {

//    class NumArray {
//
//        private int[] mNums;
//
//        public NumArray(int[] nums) {
//            mNums = nums;
//        }
//
//        public int sumRange(int i, int j) {
//            int sum = 0;
//
//            for (; i <= j && i < mNums.length;i++) {
//                sum += mNums[i];
//            }
//            return sum;
//        }
//    }

//    class NumArray {
//        private HashMap<Pair<Integer, Integer>, Integer> map;
//
//        public NumArray(int[] nums) {
//            map = new HashMap<>();
//
//            for (int i = 0; i < nums.length; i++) {
//                int sum = 0;
//                for (int j = i; j < nums.length; j++) {
//                    sum += nums[j];
//                    map.put(new Pair<>(i,j), sum);
//                }
//            }
//        }
//
//        public int sumRange(int i, int j) {
//            return map.get(new Pair<>(i,j));
//        }
//    }

    class NumArray {
        int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length];
            int c = 0;
            for (int i = 0; i < nums.length; i++) {
                c += nums[i];
                sum[i] = c;
            }
        }

        public int sumRange(int i, int j) {
            int sub = i == 0 ? 0 : sum[i - 1];
            return sum[j] - sub;
        }
    }


    public void test() {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);
        int c = array.sumRange(0, 2);
        System.out.println(c);
    }
}
