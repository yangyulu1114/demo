public class LongestPalindrome {
//    本题要注意一些edge case "a", "aa" "aaa" "aaab"
    public int longestPalindrome(String s) {
        int flag = 0, sum = 0;
        int[] count = new int['z' - 'A' + 1];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2) {
                sum += (count[i] - (count[i] % 2));
            }
            if (count[i] % 2 != 0) {
                flag = 1;
            }
        }
        return sum + flag;
    }

    public void test() {
        System.out.println(longestPalindrome("abab"));
    }
}
