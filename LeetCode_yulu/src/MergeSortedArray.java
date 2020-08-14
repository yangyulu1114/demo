public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1;
        for ( int k = m + n - 1; i >=0 && j >=0; k--) {
          nums1[k] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        if ( j >= 0) {
           System.arraycopy(nums2,0,nums1,0,j+1);
        }
    }

    public void test() {
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[] {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, 3);

        for(int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
//        for (int nf : nums1) {
//            System.out.println(nf);
//        }
    }
}
