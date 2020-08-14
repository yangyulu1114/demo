import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        char[] num = new char[n];
        constructStrobogrammatic(ans, num, 0, n - 1);
        return ans;
    }

    public void  constructStrobogrammatic(List<String> ans, char[] num, int start, int end) {
        if (end < start) {
            ans.add(new String(num));
            return;
        }
        if (end == start) {
            char[] mid = new char[]{'0', '1', '8'};
            for (char c : mid) {
                num[start] = c;
                ans.add(new String(num));
            }
            return;
        }
        if (start != 0) {
            num[start] = '0';
            num[end] = '0';
            constructStrobogrammatic(ans, num, start + 1, end - 1);
        }
        char[][] digits = new char[][]{{'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        for (int i = 0; i < digits.length; i++) {
            num[start] = digits[i][0];
            num[end] = digits[i][1];
            constructStrobogrammatic(ans, num, start + 1, end - 1);
        }
    }
}
