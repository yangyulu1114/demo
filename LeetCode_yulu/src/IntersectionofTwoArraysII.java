import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> result = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            int count = map.getOrDefault(nums1[i],0);
            count++;
            map.put(nums1[i], count);
        }
        for (int i = 0; i < nums2.length; i ++) {
            int count = map.getOrDefault(nums2[i], 0);
            if (count > 0) {
                count--;
                map.put(nums2[i], count);
                result.add(nums2[i]);
            }
        }
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }
        return intersection;
    }

    public void test() {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};

        int[] intersection = intersect(nums1, nums2);
        for (int i = 0; i < intersection.length; i++) {
            System.out.println(intersection[i]);
        }
    }
}
