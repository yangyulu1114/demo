import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    // n^2
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // nlogn
    public int[] twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; ) {
            int sum = nums[i] + nums[j];
            if (target > sum) {
                i++;
            } else if (target < sum) {
                j--;
            } else {
                return new int[] {i, j};
            }
        }
        return null;
    }

    // n
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = map.getOrDefault(target - nums[i], -1);
            if (index >= 0) {
                return new int[] {
                        index, i
                };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public void test() {
        int[] nums = {
                2, 7, 11, 15
        };
        int[] array = twoSum2(nums, 9);
        for (int a : array) {
            System.out.println(a);
        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
    }
}
