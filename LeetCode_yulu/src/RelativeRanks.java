import java.util.Arrays;
import java.util.HashMap;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; map.put(nums[i], i), i++);
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            int index = map.get(nums[i]);
            if (i == len - 1) {
                result[index] = "Gold Medal";
            } else if (i == len - 2) {
                result[index] = "Silver Medal";
            } else if (i == len - 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = "" + (len - i);
            }
        }
        return result;
    }

    //这种方法使用数组替代map，一是可以省去额外的操作，而是数组充当map，用nums[i]的值充当索引，本身就具备了排序的功能，所以也省去了排序，降低了时间复杂度
    public String[] findRelativeRanks2(int[] nums) {
        String[] ranks = new String[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] map = new int[max + 1]; //加一是因为最大索引为max
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]] = i + 1;  //这里加1是为了i = 0时所做的处理，因为后面会将map[i]==0r认为是没有该值，所以这里如果不加1会有问题
        }
        int place = 1;
        for (int i = map.length - 1; i >= 0; i--) {
            if (map[i] != 0) {
                if (place == 1) {
                    ranks[map[i] - 1] = "Glod Medal";
                } else if (place == 2) {
                    ranks[map[i] - 1] = "Silver Medal";
                } else if (place == 3) {
                    ranks[map[i] - 1] = "Bronze Medal";
                } else {
                    ranks[map[i] - 1] = String.valueOf(place);
                }
                place++;
            }
        }
        return ranks;
    }

    public void test() {
        int[] input = new int[]{5,4,3,2,1};
        String[] output = findRelativeRanks2(input);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
