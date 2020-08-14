public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {

        return findpeakIndexInMountainArray(A, 0, A.length-1);
    }

    int findpeakIndexInMountainArray(int[]A, int first, int last) {

        while (first <= last) {
            int mid = (first + last) / 2;
            if (A[mid] < A[first]) {
                last = mid -1;
                continue;
            }

            if (A[mid] < A[last]) {
                first = mid + 1;
                continue;
            }

            int firsthalfpeak = findpeakIndexInMountainArray(A,first + 1, mid);
            int secondhalfpeak = findpeakIndexInMountainArray(A, mid, last -1);
            return A[firsthalfpeak] > A[secondhalfpeak] ? firsthalfpeak : secondhalfpeak;
        }

        return first;
    }

    public int peakIndexInMountainArray2(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    public void test() {
        int[] A = new int[] {3,4,5,1};
        System.out.println(peakIndexInMountainArray(A));
    }
}
