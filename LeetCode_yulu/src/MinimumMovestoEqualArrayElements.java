public class MinimumMovestoEqualArrayElements {
//    public int minMoves(int[] nums) {
//        long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0, length = nums.length;
//        if (length < 2) {
//            return 0;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            max = Math.max(max, nums[i]);
//            min = Math.min(min, nums[i]);
//            sum += nums[i];
//        }
//        long x = max;
//        for (; (length * x - sum) % (length - 1) != 0 || (min + (length * x - sum)/ (length - 1)) < max; x++);
//        return (int)((length * x - sum) / (length - 1));
//    }

    //这里有一个很关键的点在于最小值是需要一直往上增加的
//假设y是最后的相等值，x是走的步数， 所以y = min + x(因为x每次都要走) 所以 sum(走之前数组的和) + （n - 1）* x（n - 1个数总共走的步数） = y * n;
//    所以sum + (n -1)* x = (min + x)* n ——》sum - x = min * n ,——》x = sum - min * n

    public int minMoves(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        return sum - min * nums.length;
    }
}
