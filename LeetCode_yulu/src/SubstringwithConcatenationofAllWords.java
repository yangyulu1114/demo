import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return ans;
        }
        int len = words[0].length(), total = len * words.length;
        if (s.length() < total) {
            return ans;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int start = 0; start <= s.length() - total; start++) {
            if (isMatch(s, start, start + total, len, map)) {
                ans.add(start);
            }
        }
        return ans;
    }

    public boolean isMatch(String s, int start, int end, int len, HashMap<String, Integer> map) {
        HashMap<String, Integer> map1 = new HashMap<>(map);
        for(int i = start; i < end; i += len) {
            String string = s.substring(i, i + len);
            map1.put(string, map1.getOrDefault(string, 0) - 1);
            int count = map1.get(string);
            if (count == - 1) {
                return false;
            }
            if (count == 0) {
                map1.remove(string);
            }
        }
        return map1.isEmpty();
    }

    public void test() {
        String[] words = new String[]{"foo","bar"};
        List<Integer> list = findSubstring("barfoothefoobarman", words);
        for (int n : list) {
            System.out.println(n);
        }
    }
}
