public class ReverseStringII {
    //循环一定要注意退出，edge case:"a", 2
    public String reverseStr(String s, int k) {
        char[] string = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i += (2 * k)) {
            if ((len - i) < k) {
                reverse(string, i, len - 1);
            } else {
                reverse(string, i, i + k - 1);
            }
        }
        return new String(string);
    }
    public void reverse(char[] string, int start, int end) {
        for (; start < end; start++, end--) {
            char temp = string[end];
            string[end] = string[start];
            string[start] = temp;
        }
    }

    public void test() {
        System.out.println(reverseStr("a", 2));
    }

}
