
import java.util.HashMap;
import java.util.HashSet;

public class LengthofLongestFibonacciSubsequence {
    //解题的关键在于找到第一对pre2和pre1，因为斐波那契数列的特征前两个数确定之后后面的都可以确定
    //这里的时间复杂度是N^2logM ,M是A中的最大值，因为最差的情况是一直能找到，直到A中的最大数都满足
    //空间复杂度是o(n)
    public int lenLongestFibSubseq(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; set.add(A[i]), i++);
        int max = 0;

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int pre2 = A[i], pre1 = A[j], fibonacci = pre1 + pre2;
                int length = 2;
                while (set.contains(fibonacci)) {
                    length++;
                    pre2 = pre1;
                    pre1 = fibonacci;
                    fibonacci = pre1 + pre2;
                }
                max = Math.max(max, length);
            }
        }
        return max >= 3 ? max : 0;
    }

    //第二种方法时间复杂度为O（n^2），空间复杂度O（nlogM），M是A中的最大数
    // 这种思路是动态规划，看当前的数，pre1从当前数的前面一个数去找，看能不能扎到pre2，如果能找到就是（pre2, pre1）的长度加上1就是当前pair(pre1, i)的程度
    //通过这种配对的方式可以转化为类似于Longest Increasing Subsequence.
    public int lenLongestFibSubseq2(int[] A) {
        HashMap<Integer, Integer> indexmap = new HashMap<>();
        for (int i = 0; i < A.length; indexmap.put(A[i], i++));
        int max = 0;
        HashMap<Pair<Integer, Integer>, Integer> longest = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int index = indexmap.getOrDefault((A[i] - A[j]), -1);
                if (index >= 0 && index < j) {
                    int length = longest.getOrDefault(new Pair<>(index, j), 2) + 1;
                    longest.put(new Pair<>(j, i), length);  //要注意pair对的顺序
                    max = Math.max(max, length);
                }
            }
        }
        return max >= 3 ? max : 0;
    }
//这种方法是在2的基础上用二维数组来替代map, 时间复杂度为O(n)，空间复杂度为O(n)
    public int lenLongestFibSubseq3(int[] A) {
        HashMap<Integer, Integer> indexmap = new HashMap<>();
        for (int i = 0; i < A.length; indexmap.put(A[i], i++));
        int max = 0;

        int[][] longest = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                int index = indexmap.getOrDefault((A[i] - A[j]), -1);
                if (index >= 0 && index < j) {
                    int length = longest[index][j] == 0 ? 3 : longest[index][j] + 1;
                    longest[j][i] = length;
                    max = Math.max(max, length);
                }
            }
        }
        return max >= 3 ? max : 0;
    }

    //这种方法在3的基础上是把前一个pair对的查找替换成了sum2的思路，中间查找的运算次数是一样的，但是因为不需要用到map这种复杂结构，因此能
//    节约很多时间，还省掉了一个O（n）的map
    public int lenLongestFibSubseq4(int[] A) {
        int max = 0;
        int[][] longest = new int[A.length][A.length];
        for (int k = 0; k < A.length; k ++) {
            for (int i = 0, j = k - 1; i < j;) {
                int sum = A[i] + A[j];
                if (sum == A[k]) {
                    int length = longest[i][j] == 0 ? 3 : longest[i][j] + 1;
                    max = Math.max(max, length);
                    longest[j][k] = length;
                    i++;
                    j--;
                } else if (sum > A[k]) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return max;
    }

}
