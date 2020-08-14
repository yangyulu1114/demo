public class SquaresofaSortedArray {
    //TWO POINTER
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int index = A.length - 1;
        for (int start = 0, end = A.length - 1; start <= end;) {
            if (Math.abs(A[start]) > Math.abs(A[end])) {
                ans[index--] = A[start] * A[start];
                start++;
            } else {
                ans[index--] = A[end] * A[end];
                end--;
            }
        }
        return ans;
    }
    public void test() {
    }
}
