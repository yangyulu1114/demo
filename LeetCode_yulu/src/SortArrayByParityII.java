public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        int i = 0, j = 1;
        for (int k = 0; k < A.length; k++) {
            if (A[k] % 2 == 0) {
                ans[i] = A[k];
                i += 2;
            } else {
                ans[j] = A[k];
                j += 2;
            }
        }
        return ans;
    }
    public int[] sortArrayByParityII2(int[] A) {
        for (int i = 0, j = 1; i < A.length && j <= A.length; ) {
            if (A[i] % 2 != 0 && A[j] % 2 == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i += 2;
                j += 2;
            } else if (A[i] % 2 == 0) {
                i += 2;
            } else {
                j += 2;
            }
        }
        return A;
    }
}
