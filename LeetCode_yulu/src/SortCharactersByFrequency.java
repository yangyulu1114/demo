import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: list) {
            char c = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void test() {
       System.out.println(frequencySort("tree"));
    }
}
