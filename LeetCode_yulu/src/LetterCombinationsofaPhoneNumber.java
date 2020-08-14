import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    //edge case: digits为空
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> ans = new ArrayList<>();
        combinate(ans, map, new StringBuilder(), digits, 0);
        return ans;
    }

    public void combinate(List<String> ans, HashMap<Integer, String> map, StringBuilder sb, String digits, int index ) {
        if (digits.length() == 0) {
            return;
        }
        if (index >= digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String s = map.get(digits.charAt(index) - '0');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            combinate(ans, map, sb, digits, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    public List<String> letterCombinations2(String digits) {
        String[] map = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        combinate(ans, map, new StringBuilder(), digits, 0);
        return ans;
    }

    public void combinate(List<String> ans, String[] map, StringBuilder sb, String digits, int index ) {
        if (digits.length() == 0) {
            return;
        }
        if (index >= digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String s = map[digits.charAt(index) - '2'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            combinate(ans, map, sb, digits, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
