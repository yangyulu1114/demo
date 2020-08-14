public class ValidMountainArray {
    //edge case: [], [0, 1], [1,0],[0,1,2], [2,1,0]
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int i = 0;
        for (; i < A.length - 2 && A[i] < A[i + 1]; i++) ;
        for (; i < A.length - 1; i++) {
            if (i == 0 || A[i] <= A[i + 1]) {  //这里之所以要有i== 0的判断，是怕出现一上来就单调递减的情况
                return false;
            }
        }
        return true;
    }
}
