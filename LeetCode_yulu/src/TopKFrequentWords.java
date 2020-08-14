import java.util.*;

public class TopKFrequentWords {
    //O(nlogn)
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String word : words) {
            int count = map.getOrDefault(word, 0) + 1;
            max = Math.max(max, count);
            map.put(word, count);
        }
        TreeSet<String> [] sets = new TreeSet[max + 1];
        for (String word: map.keySet()) {
            int count = map.get(word);
            if (sets[count] == null) {
                sets[count] = new TreeSet<>();   //因为这里是treeset加入，所以时间复杂度是o(logn)
            }
            sets[count].add(word);
        }
        List<String> ans = new ArrayList<>();
        for (int i = sets.length - 1, index = 0; i >= 0 && index < k; i--) {
            if (sets[i] != null) {
                TreeSet<String> set = sets[i];
                while (!set.isEmpty()){
                    ans.add(set.pollFirst());
                    if (ans.size() == k) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
//O(nlogK)
    public List<String> topKFrequent2(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2)) {
                    return o2.compareTo(o1);
                } else {
                    return map.get(o1) - map.get(o2);
                }
            }
        });
        for (String word : map.keySet()) {
            queue.add(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            ans.add(0, queue.poll());
        }
        return ans;
    }

    //O(nlogn)
    public List<String> topKFrequent3(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> ans = new ArrayList<>(map.keySet());
        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2)) {
                    return o1.compareTo(o2);
                } else {
                    return map.get(o2) - map.get(o1);
                }
            }
        });
        return ans.subList(0, k);
    }
}
