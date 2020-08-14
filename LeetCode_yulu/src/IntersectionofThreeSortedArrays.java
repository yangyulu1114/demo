import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionofThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        HashSet<Integer> set2 = new HashSet<>(), set3 = new HashSet<>();
        for (int n : arr2) {
            set2.add(n);
        }
        for (int n : arr3) {
            set3.add(n);
        }
        List<Integer> ans = new ArrayList<>();
        for (int n : arr1) {
            if (set2.contains(n) && set3.contains(n)) {
                ans.add(n);
            }
        }
        return ans;
    }
//三个数的开头比大小
    public List<Integer> arraysIntersection2(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        for (; i < arr1.length && j < arr2.length && k < arr3.length;) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                ans.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return ans;
    }
}
