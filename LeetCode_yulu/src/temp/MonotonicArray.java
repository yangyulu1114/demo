package temp;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        int predirection = 0, direction = 0;
        for (int i = 0; i < A.length - 1; i++) {
           if (A[i + 1] > A[i]) {
               direction = predirection + 1;
           } else if (A[i + 1] < A[i]) {
               direction = predirection - 1;
           }

           if (Math.abs(direction) < Math.abs(predirection)) {
               return false;
           }
           predirection = direction;
        }
        return true;
    }

    public boolean isMonotonic2(int[] A) {
        return increasing(A) || decreasing(A);
    }

    public boolean increasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] < A[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean decreasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] > A[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonic3(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int c = Integer.compare(A[i + 1], A[i]);
            if (c != 0) {
                if (store != 0 && c != store) {
                    return false;
                }
                store = c;
            }
        }
        return true;
    }

    public boolean isMonotonic4(int[] A) {
        boolean isIncreasing = true, isDreasing = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] > A[i]) {
                isDreasing = false;
            }
            if (A[i + 1] < A[i]) {
                isIncreasing = false;
            }
        }
        return isDreasing || isIncreasing;
    }

    public void test() {
        int[] input = new int[]{5,3,2,4,1};
        System.out.println(isMonotonic(input));
    }
}
