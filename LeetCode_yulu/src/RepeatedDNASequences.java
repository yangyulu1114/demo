import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            if (sb.length() == 0) {
                sb.append(s.substring(i, i + 10));
            } else {
                sb.deleteCharAt(0);
                sb.append(s.charAt(i + 9));
            }
            String string = sb.toString();
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String string = s.substring(i, i + 10);
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}
