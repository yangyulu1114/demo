import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsinaString {
    //暴力法，超时了
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        int slen = s.length(), plen = p.length();
        for (int i = 0; i <= slen - plen; i++) {
            String string = s.substring(i, i + plen);
            if (isAnagrams(string, p)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    //Hashmap实现的slideview
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int slen = s.length(), plen = p.length();
        if (slen < plen) {
            return ans;
        }
        HashMap<Character, Integer> sCount = new HashMap<>(), pCount = new HashMap<>();
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);

            if (i >= plen) {
                char pre = s.charAt(i - plen);
                if (sCount.get(pre) == 1) {
                    sCount.remove(pre);
                } else {
                    sCount.put(pre, sCount.get(pre) - 1);
                }
            }
            if (sCount.equals(pCount)) {  //map的比较方式
                ans.add(i - plen + 1);
            }
        }
        return ans;
    }
//数组实现的slideview
    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int slen = s.length(), plen = p.length();
        if (slen < plen) {
            return ans;
        }
        int[] sCount = new int[26], pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        for (int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            sCount[c - 'a']++;

            if (i >= plen) {
                char pre = s.charAt(i - plen);
                sCount[pre - 'a']--;
            }
            if (Arrays.equals(sCount, pCount)) {  //数组的比较方式
                ans.add(i - plen + 1);
            }
        }
        return ans;
    }
}
