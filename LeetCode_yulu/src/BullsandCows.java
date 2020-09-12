import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BullsandCows {
//    public String getHint(String secret, String guess) {
//        HashMap<Character, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < secret.length(); i++) {
//            char c = secret.charAt(i);
//            List<Integer> list = map.get(c);
//            if (list == null) {
//                list = new LinkedList<>();
//            }
//            list.add(i);
//            map.put(c, list);
//        }
//        int bulls = 0, cows = 0;
//        for (int i = 0; i < guess.length(); i++) {
//            char c = guess.charAt(i);
//            List<Integer> list = map.get(c);
//            if (list != null) {
//                int j = 0;
//                for (; j < list.size(); j++) {
//                    if (list.get(j) == i) {
//                        bulls++;
//                        break;
//                    }
//                }
//                if (j >= list.size()) {
//                    list.remove(j - 1);
//                    cows += j >= list.size() ? 1 : 0;
//                } else {
//                    list.remove(j);
//                }
//                if (list.size() > 0) {
//                    map.put(c,list);
//                } else {
//                    map.remove(c);
//                }
//            }
//        }
//        return bulls + "A" + cows + "B";
//    }

    public String getHint(String secret, String guess) {
        HashMap<Character, Set<Integer>> map1 = new HashMap<>();
        HashMap<Character, Set<Integer>> map2 = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            Set<Integer> set = map1.getOrDefault(c, new HashSet<>());
            set.add(i);
            map1.put(c,set);
        }

        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            Set<Integer> set = map2.getOrDefault(c,new HashSet<>());
            set.add(i);
            map2.put(c,set);
        }

        int bulbs = 0, cows = 0;
        for (Character key : map2.keySet()) {
            Set<Integer> set1 = map1.get(key);

            if (set1 == null) {
                continue;
            }

            Set<Integer> set2 = map2.get(key);

            int count = 0;
            for (Integer index : set2) {
                if (set1.contains(index)) {
                    count++;
                }
            }
            bulbs += count;
            cows += Math.min(set1.size(), set2.size()) - count;
        }

        return bulbs + "A" + cows + "B";
      }

    public String getHint2(String secret, String guess) {
        int bulbs = 0, cows = 0;
        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulbs++;
                continue;
            }
            if (++count[secret.charAt(i) - '0'] <= 0) {
                cows++;
            }
            if (--count[guess.charAt(i) - '0'] >= 0 ) {
                cows++;
            }
        }
//        return bulbs + "A" + cows + "B";
//        尽量不要使用字符串+这种操作
        StringBuilder sb=new StringBuilder();
        return sb.append(bulbs).append("A").append(cows).append("B").toString();

    }

    public void test() {
        System.out.println(getHint2("1807", "7810"));
//        edge case ： 【1122】【1222】 ——》3A0B  【1123】【0111】 ——》1A1B
    }
}
