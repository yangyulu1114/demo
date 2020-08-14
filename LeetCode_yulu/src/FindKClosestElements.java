import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> ans = new ArrayList<>();
//        int start = 0, end = arr.length - 1;
//        while (start < end) {
//            int mid = (start + end) / 2;
//            if (arr[mid] == x) {
//                start = mid;
//                break;
//            } else if (arr[mid] > x) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        ans.add(arr[start]);
//        for (int left = start - 1, right = start + 1 ,count = 1; count < k ; count++) {
//            if (left < 0 || (right < arr.length && Math.abs(arr[left] - x) > Math.abs(arr[right] - x))) {
//                ans.add(arr[right++]);
//            } else if (right >= arr.length || (right < arr.length && Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))) {
//                ans.add(0, arr[left--]);
//            }
//        }
//        return ans;
//    }

    //通过二分查找找到满足条件的数组index范围
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int end = arr.length - 1, start = 0;
        if (x <= arr[0]) {
            start = 0;
        } else if (x >= arr[end]) {
            start = end - k + 1;
        } else {
            int index = Arrays.binarySearch(arr, x);  //注意当数组内没有x时，返回的是第一个比x大的数的index的相反数
            if (index < 0) {
                index = - index - 1;
            }
            int low = Math.max(0,index - k), high = Math.min(end, index + k - 1);
            while (high - low + 1 > k) {
                if (x - arr[low] > arr[high] - x) {
                    low++;
                } else {
                    high--;
                }
            }
            start = low;
        }
        for (int i = 0; i < k; i++) {
            ans.add(arr[start++]);
        }
        return ans;
    }

    public void test() {
        int[] arr = new int[]{1,1,1,10,10,10};
        System.out.println(findClosestElements(arr, 1, 9));
    }
}
