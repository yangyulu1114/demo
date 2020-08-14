import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> count : map.entrySet()) {
            if (count.getValue() > length / 2) {
                return count.getKey();
            }
        }
        return -1;
    }

    public int majorityElement3(int[] nums) {
        int candidate = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }

            count += nums[i] == candidate ? 1 : -1;
        }

        return candidate;
    }

    public void test() {
        int[] input = new int[] {2,2,1,1,1,2,2};
        System.out.println(majorityElement2(input));
    }
}
