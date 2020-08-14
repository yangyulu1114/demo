import java.util.HashMap;
import java.util.Map;

public class DegreeofanArray {
    public int findShortestSubArray3(int[] nums) {
        int degree = 0, result = nums.length;
        HashMap<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            first.putIfAbsent(x, i);
            int n = count.getOrDefault(x, 0) + 1;
            count.put(x, n);
            if (n > degree) {
                degree = n;
                result = i - first.get(x) + 1;
            } else if (n == degree) {
                result = Math.min(result, i - first.get(x) + 1);
            }
        }
        return result;
    }

    public int findShortestSubArray2(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>(), left = new HashMap<>(), right = new HashMap<>();
        int degree = 0, result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int n = count.getOrDefault(nums[i], 0) + 1;
            degree = Math.max(degree, n);
            count.put(nums[i], n);
            if (left.get(nums[i]) == null) {
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == degree) {
                result = Math.min(result, right.get(entry.getKey())- left.get(entry.getKey()) + 1);
            }
        }
        return result;
    }

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int degree = 0, result = Integer.MAX_VALUE;
        for (int n : nums) {
            int count = map.getOrDefault(n, 0) + 1;
            degree = Math.max(degree, count);
            map.put(n, count);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == degree){
                int length = getLength(nums, entry.getKey());
                result = Math.min(result, length);
            }
        }
        return result;
    }

    public int getLength(int[] nums, int val) {
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                continue;
            }
            if (start == -1) {
                start = i;
                end = i;
            } else {
                end = i;
            }
        }
        return end - start + 1;
    }

    public void test() {
        int[] input = new int[]{1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(input));
    }
}
