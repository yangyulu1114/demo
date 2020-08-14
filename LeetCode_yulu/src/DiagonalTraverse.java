import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {
   // 这种方法就是扫每一个对角线，每一次都从最顶上扫，有一些扫了之后要反转
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int M = matrix.length, N = matrix[0].length;
        int[] ans = new int[M * N];
        int k = 0;
        List<Integer> intermediate = new ArrayList<>();

        for (int d = 0; d < M + N - 1; d++) {
            intermediate.clear();
            int m = d < N ? 0 : d - N + 1;
            int n = d < N ? d : N - 1;

            while (m < M && n >= 0) {
                intermediate.add(matrix[m][n]);
                m++;
                n--;
            }

            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }
            for (int num : intermediate) {
                ans[k++] = num;
            }
        }
        return ans;
    }
//模拟真实过程，需要有一个变量保存方向
    public int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int M = matrix.length, N = matrix[0].length;
        int[] ans = new int[M * N];
        boolean up = true;
        int k = 0, m = 0, n = 0;

        while (m < M && n < N) {
            ans[k++] = matrix[m][n];
            int nextRow = m + (up ? -1 : 1);
            int nextColum = n + (up ? 1 : -1);

            if (nextRow < 0 || nextRow == M || nextColum < 0 || nextColum == N) {
                if (up) {
                    nextRow = (n + 1 < N ? m : m + 1);   //这里的头部选择要注意
                    nextColum = (n + 1 < N ? n + 1 : n);
                } else {
                    nextRow = (m + 1 < M ? m + 1 : m);
                    nextColum = (m + 1 < M ? n : n + 1);
                }
                up = !up;
            }
            m = nextRow;
            n = nextColum;
        }
        return ans;
    }

    }
