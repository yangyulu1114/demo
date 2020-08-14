public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        //注意operations为空的时候所有值都是最大的，所以应该返回m * n
        if (ops.length == 0) {
            return ops.length * ops.length;
        }
        int minXcount = ops[0][0], minYcount = ops[0][1];
        for (int i = 1; i < ops.length; i++) {
            minXcount = Math.min(minXcount, ops[i][0]);
            minYcount = Math.min(minYcount, ops[i][1]);
        }
        return minXcount * minYcount;
    }
}
