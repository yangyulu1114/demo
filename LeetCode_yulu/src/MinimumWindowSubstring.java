import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (slen == 0 || tlen == 0) {
            return "";
        }
        HashMap<Character, Integer> sCount = new HashMap<>(), tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        int required = tCount.size(), formed = 0;
        int[] ans = new int[]{-1, 0, 0};
        for (int start = 0, end = 0; end < slen; end++) {
            char c = s.charAt(end);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
            if (tCount.containsKey(c)) {
                if (sCount.get(c).equals(tCount.get(c))) {   //JAVA对象不能直接用等号比，基本对象才行
                    formed++;
                }
            }
            while (start <= end && formed == required) {
                c = s.charAt(start);
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }
                sCount.put(c, sCount.get(c) - 1);
                if (tCount.containsKey(c) && sCount.get(c).intValue() < tCount.get(c).intValue()) {
                    formed--;
                }
                start++;
            }
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public String minWindow2(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (slen == 0 || tlen == 0) {
            return "";
        }
        HashMap<Character, Integer> sCount = new HashMap<>(), tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        List<Pair<Integer, Character>> filters = new ArrayList<>();
        for (int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            if (tCount.containsKey(c)) {
                filters.add(new Pair<>(i, c));
            }
        }
        int required = tCount.size(), formed = 0;
        int[] ans = new int[]{-1, 0, 0};
        for (int start = 0, end = 0; end < filters.size(); end++) {
            char c = filters.get(end).getValue();
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
            if (tCount.containsKey(c)) {
                if (sCount.get(c).equals(tCount.get(c))) {   //JAVA对象不能直接用等号比，基本对象才行
                    formed++;
                }
            }
            while (start <= end && formed == required) {
                c = filters.get(start).getValue();
                int l = filters.get(start).getKey(), r = filters.get(end).getKey();
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                sCount.put(c, sCount.get(c) - 1);
                if (tCount.containsKey(c) && sCount.get(c).intValue() < tCount.get(c).intValue()) {
                    formed--;
                }
                start++;
            }
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
}
