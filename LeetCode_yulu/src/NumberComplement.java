public class NumberComplement {
    //这个题目要注意0转为1这里不能直接用取非运算，因为这里不是bit位，是int型，如果用~，会默认当成32位整数来取非，所以1取非就会变成负数了
    public int findComplement(int num) {
        int result = 0;
        for (int i = 0; i < 32 && num > 0; i++) {
            int temp = (num & 1);
            temp = temp == 0 ? 1 : 0;
            temp <<= i;
            result += temp;
            num >>>= 1;
        }
        return result;
    }

    public void test() {
        System.out.println(findComplement(1));
    }
}
