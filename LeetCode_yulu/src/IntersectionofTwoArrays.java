import java.util.HashSet;

public class IntersectionofTwoArrays {
//    public int[] intersection(int[] nums1, int[] nums2) {
//
//        if (nums1.length == 0 || nums2.length == 0) {
//            return null;
//        }
//
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//
//        List<Integer> list = new LinkedList<>();
//        int pre = -1;
//
//        for (int i = 0; i < nums1.length; i++) {
//            if (nums1[i] != pre || i == 0) {
//                boolean insected = existinArray(nums1[i], nums2);
//                if (insected) {
//                    list.add(nums1[i]);
//                }
//            }
//            pre = nums1[i];
//        }
////        return list.toArray(new int[0]);
//    }
//
//    public boolean existinArray(int number, int[]nums) {
//        int i = 0, j = nums.length - 1;
//        while (i <= j) {
//            int mid = (i + j) / 2;
//            if (nums[mid] > number) {
//                j = mid -1;
//            } else if (nums[mid] < number) {
//                i = mid + 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public int[] intersection2(int[] nums1, int[] nums2) {
//        if (nums1.length == 0 || nums2.length == 0) {
//            return null;
//        }
//
//        HashSet<Integer> set = new HashSet<>();
//        List<Integer> list = new LinkedList<>();
//        Arrays.sort(nums2);
//
//        for (int i = 0; i < nums1.length; i++) {
//            if (set.add(nums1[i])) {
//                boolean insected = existinArray(nums1[i], nums2);
//                if (insected) {
//                    list.add(nums1[i]);
//                }
//            }
//        }
//        return list.toArray(new int[0]);
//    }

    public int[] intersection3(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                result.add(nums2[j]);
            }
        }

        int i = 0;
        int[] intersection = new int[result.size()];
        for (Integer n : result) {
            intersection[i++] = n;
        }
        return intersection;
    }

    public void test() {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] result = intersection3(nums1,nums2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
