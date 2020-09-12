
import java.util.HashSet;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII {
    public String removeDuplicates(String s, int k) {
        HashSet<String> duplicate = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            sb.setLength(0);
            for (int n = 0; n < k; n++) {
                sb.append(i);
            }
            duplicate.add(sb.toString());
        }
        int prevLength = -1;
        while (prevLength != s.length()) {
            prevLength = s.length();
            for (String d : duplicate) {
                s = s.replace(d, "");
            }
        }
        return s;
    }
    //和上面的一样，但是能省一些空间
    public String removeDuplicates2(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int length = -1;
        while (length != sb.length()) {
            length = sb.length();
            for (int i = 0, count = 1; i < sb.length(); ++i) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    count = 1;
                } else if (++count == k) {
                    sb.delete(i - k + 1, i + 1);
                    break;
                }
            }
        }
        return sb.toString();
    }
//和上面相比，这种方法是用一些额外的空间存储字符出现的次数，如果达到k之后就删除，可以将时间复杂度降到O(N)
    public String removeDuplicates3(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int[] count = new int[s.length()];
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i -= k;
                }
            }
        }
        return sb.toString();
    }
//方法4和方法3比，使用栈来存储次数，而不是数组
    public String removeDuplicates4(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1) ){
                stack.push(1);
            } else {
                int count = stack.pop() + 1;
                if (count == k) {
                    sb.delete(i - k + 1, i + 1);
                    i -= k;
                } else {
                    stack.push(count);
                }
            }
        }
        return sb.toString();
    }

    //方法5相对于方法4，是遍历的过程中不修改，用栈保存pair(字符，次数)对，最后在生成新的sb
    public String removeDuplicates5(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c != stack.peek().getKey()) {
                stack.push(new Pair<>(c, 1));
            } else {
                int count = stack.pop().getValue() + 1;
                if (count < k) {
                    stack.push(new Pair<>(c, count));
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.peek().getKey();
            int count = stack.pop().getValue();
            for(int i = 0; i < count; i++) {
                ans.append(c);
            }
        }
        return ans.reverse().toString();
    }
//TWO POINTER, 方法6是在方法4的基础上，不用在遍历过程中对sb做删除操作，只需要对数组就行覆盖操作，即移动index即可
    //分快慢两个指针，i走的快，j走的慢，因为j是用来复制的，可以回退,用回退来模拟删除
    public String removeDuplicates6(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        char[] ans = s.toCharArray();
        int j = 0;
        for (int i = 0; i < ans.length; i++, j++) {
            ans[j] = ans[i];
            if (j == 0 || ans[j] != ans[j - 1]) {
                stack.push(1);
            } else {
                int count = stack.pop() + 1;
                if (count == k) {
                    j -= k;
                } else {
                    stack.push(count);
                }
            }
        }
        return new String(ans, 0, j);
    }

    //这么写会有问题，比如case:"deeedbbcccbdaa",当删了eee之后和ccc之后问题会出现,要修改，修改成方法4，不入栈字符，入栈次数
//    public String removeDuplicates2(String s, int k) {
//        Stack<Character> stack = new Stack<>();
//        int count = 0;
//        char pre = 'a';
//        for (char c : s.toCharArray()) {
//            if (stack.isEmpty() || c != pre) {
//                pre = c;
//                count = 0;
//            }
//            stack.push(c);
//            count++;
//            if (count == k) {
//                for (int i = 0; i < k; i++) {
//                    stack.pop();
//                }
//                pre = stack.peek();
//                count = 1;
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//        return sb.reverse().toString();
//    }

    public void test() {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }
}
