import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, "", 0, 0, n);
        return ans;
    }

    public void generate(List<String> ans, String s, int open, int close, int n) {
        if (s.length() == n * 2) {
            ans.add(s);
            return;
        }

        if (open < n) {
            generate(ans, s + "(", open + 1, close, n);
        }
        if (close < open) {
            generate(ans, s + ")", open, close + 1, n);
        }
    }

    public void test() {
        List<String> list = generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
