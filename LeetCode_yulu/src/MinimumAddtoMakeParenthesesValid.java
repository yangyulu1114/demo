import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }
        count += stack.size();
        return count;
    }
//这个题目不需要用栈来保存字符，只需要用balance变量来记录之前出现的是'(还是'）'
    public int minAddToMakeValid2(String S) {
        int ans = 0, balance = 0;
        for (char c : S.toCharArray()) {
            balance += (c == '(' ? 1 : -1);
            if(balance == -1) { //如果'）'多了马上就要补
                ans++;
                balance = 0;

            }
        }
        ans += balance;  //如果'（'多了，最后补
        return ans;
    }
}
