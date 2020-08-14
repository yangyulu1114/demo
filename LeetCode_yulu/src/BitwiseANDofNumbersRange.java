public class BitwiseANDofNumbersRange {
   //这会超时
    public int rangeBitwiseAnd(int m, int n) {
        int ans = m;
        for (int cur = m + 1; cur <= n; cur++) {
            ans &= cur;
        }
        return ans;
    }

    //只要m和n不等，那就肯定会存在至少一对一奇一偶，那最后一个bit位与运算之后就会为0
    public int rangeBitwiseAnd2(int m, int n) {
        int moveFactor = 1;
        while (m != n) {
            moveFactor <<= 1;
            m >>= 1;
            n >>= 1;
        }
        return moveFactor * m;
    }
}
