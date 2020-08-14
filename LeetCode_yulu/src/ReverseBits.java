public class ReverseBits {
    public int reverseBits2(int n) {
        int result = 0;
//        位运算的运算符的优先级比较低，所以要记住括号
// >>表示有符号右移，即：如果是正数，则前面补0，如果是负数，则前面补1。
// >>>表示无符号右移，即无论是正数还是负数，前面都补0。

        for (int index = 0; n != 0 || index < 32; n = n >>> 1, index++) {
// 因为java是signed，所以注意这里是!=0 而不是>0
            if (n != 0) {
//                n & 1可以得到末尾
                result = (result << 1) + (n & 1);
            } else {
//不到32位的数要补全32位
                result = result << 1;
            }
        }
        return result;
    }

    public int reverseBits(int n) {
//        这里是toBinanryString,不是toString
        String bits = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(bits).reverse();
        for (int i = sb.length(); i < 32; i++, sb.append('0'));
        long val = Long.valueOf(sb.toString(), 2);
        return (int) val;
    }

    public void test() {
//        int n = Math.toIntExact(Long.valueOf("11111111111111111111111111111101", 2));
       System.out.println(reverseBits2(-3));
    }
}
