public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = A.length - 1; i < j;) {
            if (A[i] % 2 != 0 && A[j] % 2 == 0) {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                i++;
                j--;
            } else if (A[i] % 2 == 0) {
                i++;
            } else if (A[j] % 2 != 0) {
                j--;
            }
        }
        return A;
    }
}
