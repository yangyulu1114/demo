import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String hashCode = hashcode(s);
            List<String> list = map.getOrDefault(hashCode, new ArrayList<>());
            list.add(s);
            map.put(hashCode, list);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> list : map.values()) {
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }

  //这个hash值的计算再研究下
    public String hashcode(String s) {
        int diff = (int)s.charAt(0) - (int)'a';
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
            sb.append((c + 26 - diff) % 26);

        return sb.toString();
    }

    public void test() {
        String[] strings = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> list = groupStrings(strings);
        for (List<String> a : list) {
            for (String s : a) {
                System.out.print(s);
                System.out.print("    ");
            }
            System.out.println(" ");
        }
    }
}
