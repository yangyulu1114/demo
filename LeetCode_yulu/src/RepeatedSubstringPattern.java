public class RepeatedSubstringPattern {
//    本题的思路就是去试，截取一部分字符串，一直copy，看能不能匹配，先截取一半，只copy两次，最大的copy次数是n，这时截取的字符串长度仅为1
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern2(String s) {
        int l = s.length();
        for (int i = l/2; i > 0; i--) {
            if (l % i == 0) {
                StringBuilder sb = new StringBuilder();
                String sub = s.substring(0, i);  //这里要注意substring前半部分是闭区间，后半部分是开区间
                for (; sb.length() < l; sb.append(sub));
                if (sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern3(String s) {
        int l = s.length();
        boolean flag = true;
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {                 //过滤条件很重要，首先如果截取的字符串长度都不能被字符串s的长度整除，那肯定是无法通过copy得到的
                int m = l / i; //copy次数
                if (m % 2 == 0 && !flag) {     //第二个过滤条件，如果copy两次不行，那copy两次的倍数肯定也不行
                    continue;
                }
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if (sb.toString().equals(s)) return true;
                flag = false;
            }
        }
        return false;
    }

    public void test() {
        System.out.println(repeatedSubstringPattern("abab"));
    }
}
