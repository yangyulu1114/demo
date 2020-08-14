public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, half = (m + n + 1) / 2;
        int[] array = new int[m + n];
        for (int index = m + n - 1, i = m - 1, j = n -1; i >= 0 || j >= 0;) {
            if (i < 0) {
                array[index--] = nums2[j--];
            } else if (j < 0) {
                array[index--] = nums1[i--];
            } else {
                array[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            }
        }
        return (m + n) % 2 == 0 ? (array[half - 1] + array[half]) / 2.0 : array[half - 1];
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, total = len1 + len2;
        if (total % 2 != 0) {
            return findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, total / 2 + 1);
        } else {
            return (findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, total / 2) +
                    findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, total / 2 + 1)) / 2.0;
        }
    }

    public int findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1, len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return findKth(nums2, start2, end2, nums1, start1, end1, k);  //这里的return别忘了，要保证len1始终是小的
        } else if (len1 == 0) {
            return nums2[start2 + k - 1];
        } else if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int la = Math.min(k / 2, len1), lb = k - la;  //这里la不能直接等于k，因为有可能两个组数刚好一样长，这个时候len1 = k了，下面就会出现越界
        if (nums1[start1 + la - 1] > nums2[start2 + lb - 1]) {
            return findKth(nums1, start1, start1 + la - 1, nums2, start2 + lb, end2, k - lb);
        } else if (nums1[start1 + la - 1] < nums2[start2 + lb - 1]) {
            return findKth(nums1, start1 + la, end1, nums2, start2, start2 + lb - 1, k - la);
        } else {
            return nums2[start2 + lb - 1];
        }
    }


    public void test() {
        int[] nums1 = new int[]{1,2}, nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }
}
