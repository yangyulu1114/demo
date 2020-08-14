package temp;

import java.util.HashSet;

public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        int sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; sumA += A[i], i++);
        for (int i = 0; i < B.length; set.add(B[i]), sumB += B[i], i++);
        int increment = (sumB - sumA) / 2;
        for (int n : A) {
            if (set.contains(n + increment)) {
                return new int[]{n, n + increment};
            }
        }
        return new int[2];
    }
}
