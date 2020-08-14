import java.util.Arrays;
import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] ops) {
        int[] scores = new int[ops.length];
        Arrays.fill(scores, Integer.MAX_VALUE);
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            if (s.equals("+")) {
                int num = 0;
                for (int index = i -1, count = 0; index >= 0 && count < 2; index--) {
                    if (scores[index] != Integer.MAX_VALUE) {
                        count++;
                        num += scores[index];
                    }
                }
                scores[i] = num;
            } else if (s.equals("D")) {
                int index = i - 1;
                for (; index >= 0 && scores[index] == Integer.MAX_VALUE; index--);
                scores[i] = scores[index] * 2;
            } else if (s.equals("C")) {
                int index = i - 1;
                for (; index >= 0 && scores[index] == Integer.MAX_VALUE; index--);
                scores[index] = Integer.MAX_VALUE;
            } else {
                int num = Integer.parseInt(s);
                scores[i] = num;
            }
        }
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i] == Integer.MAX_VALUE ? 0 : scores[i];
        }
        return sum;
    }

    public int calPoints2(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String s : ops) {
            if (s.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                int num = Integer.valueOf(s);
                stack.push(num);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public void test() {
        String[] input = new String[]{"5","2","C","D","+"};
        System.out.println(calPoints2(input));
    }
}
