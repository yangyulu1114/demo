public class StrobogrammaticNumber {
    //本题要注意退出时，有可能还有一个字符没check，那这个字符只能是0，1或者8，如果是所有字符都check了，那直接返回true就可以了
    public boolean isStrobogrammatic(String num) {
        int i = 0, j = num.length() - 1;
        for (; i < j; i++, j--) {
            int left = num.charAt(i) - '0', right = num.charAt(j) - '0';
            if ((left == 0 && right == 0) || (left == 1 && right == 1) || (left == 8 && right == 8)
                    || (left == 6 && right == 9) || (left == 9 && right == 6)) {
                continue;
            } else {
                return false;
            }
        }
        if (i > j) {
            return true;
        }
        int mid = num.charAt(i) - '0';
        return mid == 0 || mid == 1 || mid == 8;
    }

    public void test() {
        System.out.println(isStrobogrammatic("69"));
    }
}
