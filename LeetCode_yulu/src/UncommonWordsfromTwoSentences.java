import java.util.*;

public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (String s : A.split(" ")) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : B.split(" ")) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);

        }
        for (Map.Entry<String, Integer> entey : map1.entrySet()) {
            if (entey.getValue() == 1 && (!map2.containsKey(entey.getKey()))) {
                ans.add(entey.getKey());
            }
        }
        for (Map.Entry<String, Integer> entey : map2.entrySet()) {
            if (entey.getValue() == 1 && (!map1.containsKey(entey.getKey()))) {
                ans.add(entey.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }

    //其实有一个hashmap就行了
    public String[] uncommonFromSentences2(String A, String B) {
        List<String> ans = new LinkedList<>();
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : A.split(" ")) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        for (String s : B.split(" ")) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }
}
