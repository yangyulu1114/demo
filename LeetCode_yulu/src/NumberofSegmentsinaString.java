public class NumberofSegmentsinaString {
//    edge case "", ", , , ,        a, eaefa", ", , , ,        a, eaefa   "
//    要注意一些edge case，空字符串，中间有很多空格，末尾有很多空格，开头有很多空格，全是空格
    public int countSegments(String s) {
        int sum = 0, flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                flag = 1;
            } else if (s.charAt(i) == ' ' && flag == 1) {
                sum++;
                flag = 0;
            }
        }
        return sum+flag;
    }

    public int countSegments3(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                sum++;
            }
        }
        return sum;
    }

//注意先去掉头尾的空格，java的""split出来length为1，所以要判断s的length是不是为0
    public int countSegments2(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        String[] segments = s.split("\\s+");  // \\表示空格，回车，换行等空白符，+表示一个或多个的意思
        return segments.length;
    }


    public void test() {
        System.out.println(countSegments3("    foo    bar"));
    }
}
