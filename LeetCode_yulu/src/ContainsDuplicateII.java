import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) { //特殊案例【1，0，1，1】，如果后面出现了重复数字，但是相隔超过k,就需要重新put 到map里
                    return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public void test() {
        int[] input = new int[] {1,0,1,1};
        System.out.println(containsNearbyDuplicate(input, 1));
    }
}