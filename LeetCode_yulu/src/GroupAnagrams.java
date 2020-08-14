import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String code = getcode(strs[i]);
            List<String> index = new LinkedList<>();
            if (map.containsKey(code)) {
                index = map.get(code);
            }
            index.add(strs[i]);
            map.put(code, index);
        }

        List<List<String>> list = new LinkedList<>();
        for (List<String> n : map.values()) {
            list.add(n);
        }
        return list;
    }

    public String getcode(String s) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return new String(str); //不能直接str.toString,哪些能哪些不能要搞清楚
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String hashCode = hash(s);
            List<String> list = map.getOrDefault(hashCode, new ArrayList<>());
            list.add(s);
            map.put(hashCode, list);
        }
        for (List<String> list : map.values()) {
            ans.add(list);
        }
        return ans;
    }
    //第二种方法和第一种的区别在于hash的方法不一样，第一种要经过排序，第二种因为组成字符串的字母只有小写字母
    //所以可以转变为有字母的数量和字母来表示hash值，这样时间复杂度降为O(K)

    public String hash(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                sb.append(count[i]).append((char) ('a' + i));
            }
        }
        return sb.toString();
    }

    public void test() {
        String[] input  = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list = groupAnagrams(input);

        for (int i = 0; i < list.size(); i++) {
            List<String> s = list.get(i);
            for (int j = 0;  s != null && j < s.size(); j++) {
                System.out.print(s.get(j) + "     ");
            }
            System.out.println();
        }

//        Map<String, Integer> map = new HashMap<>();
//        for (String key : map.keySet()) {
//            Integer n = map.get(key);
//        }
//        for (Integer n : map.values()) {
//
//        }
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            entry.getKey();
//            entry.getValue();
//        }
    }
}
