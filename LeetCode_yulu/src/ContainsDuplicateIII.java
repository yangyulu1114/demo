import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k && (i + j) < nums.length; j++) {
                long diff = (long) nums[i + j] - (long) nums[i]; //注意溢出
                if (Math.abs(diff) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            Long c = set.ceiling((long)nums[i]);
            if (c != null && c - nums[i] <= t) {
                return true;
            }
            Long f = set.floor((long) nums[i]);
            if (f != null && nums[i] - f <= t) {
                return true;
            }
            set.add((long)nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


    public void test() {
        int[] input = new int[]{2147483647,-2147483647};
        System.out.println(containsNearbyAlmostDuplicate(input, 1, 2147483647));
        TreeSet<Long> set = new TreeSet<>();
        set.add(1l);
        set.add(5l);
        set.add(3l);
        System.out.println(set.ceiling(2l));

    }
}
