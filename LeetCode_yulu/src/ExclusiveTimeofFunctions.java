import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int[] ans = new int[n];
        int i = 1, pre = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            int current = Integer.parseInt(s[2]);
            if (s[1].equals("start")) {  //这里要注意如果新的日志是start，那栈有可能为空，要判断
                if (!stack.isEmpty()) {
                    ans[stack.peek()] += current - pre;
                }
                pre = current;
                stack.push(Integer.parseInt(s[0]));
            } else {
                ans[stack.peek()] += current - pre + 1;
                stack.pop();
                pre = current + 1;  //这里要加以是因为start都是时间戳的开头，end都是时间戳的结尾
            }
            i++;
        }
        return ans;
    }
}
