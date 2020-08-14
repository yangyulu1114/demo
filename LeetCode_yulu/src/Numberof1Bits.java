public class Numberof1Bits {
    public int hammingWeight(int n) {
        int number = 0;
        for (; n != 0; n = n >>> 1) {
            if ((n & 1) == 1) {
              number++;
            }
        }
        return number;
    }

    public int hammingWeight2(int n) {
        int number = 0;
        while (n != 0) {
//          用n & (n -1) 可以去掉最低位的1
//          n &= (n - 1)比n = n & (n - 1)要快;
            n &= (n - 1);
            number++;
        }
        return number;
    }

    public void test() {
        System.out.println(hammingWeight2(-3));
    }
}
