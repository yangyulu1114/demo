import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> list = new ArrayList<>();
        for (char c : S.toCharArray()) {
            if (!Character.isLetter(c)) {
                if (list.size() == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    list.add(sb);
                } else {
                    for (StringBuilder sb : list) {
                        sb.append(c);
                    }
                }
            } else {
                addCases(c, list);
            }
        }
        List<String> ans = new ArrayList<>();
        for (StringBuilder sb : list) {
            ans.add(sb.toString());
        }
        return ans;
    }

    public void addCases(char c, List<StringBuilder> list) {
        if (list.size() == 0) {
            StringBuilder sb = new StringBuilder();
            list.add(sb);
        }
        int len = list.size();
        c = Character.toLowerCase(c);
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(i)).append(Character.toUpperCase(c));
            list.get(i).append(c);
            list.add(sb);
        }
    }

    public void test() {
        List<String> output = letterCasePermutation2("a1b2");
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }

    //广度遍历
    public List<String> letterCasePermutation2(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        for (int i = 0; i < S.length(); i++) {
            if (!Character.isLetter(S.charAt(i))) {
                continue;
            }
            int len = queue.size();
            for (int index = 0; index < len; index++) {
                String string = queue.poll();
                char[] letters = string.toCharArray();
                letters[i] = Character.toLowerCase(letters[i]);
                queue.offer(new String(letters));
                letters[i] = Character.toUpperCase(letters[i]);
                queue.offer(new String(letters));
            }
        }
        return new ArrayList<>(queue);
    }

    //深度遍历
    public List<String> letterCasePermutation3(String S) {
        List<String> list = new ArrayList<>();
        char[] letters = S.toCharArray();
        helper(list, letters, 0);
        return list;
    }

    public void helper(List<String> list, char[] letters, int index){
        if (index == letters.length) {
            list.add(new String(letters));
            return;
        }
        if (!Character.isLetter(letters[index])) {
            helper(list, letters, index + 1);
            return;
        }
        letters[index] = Character.toUpperCase(letters[index]);
        helper(list, letters, index + 1);

        letters[index] = Character.toLowerCase(letters[index]);
        helper(list, letters, index + 1);
    }
}
