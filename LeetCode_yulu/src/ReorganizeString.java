import javafx.util.Pair;

import java.util.*;

public class ReorganizeString {
//    public String reorganizeString(String S) {
//        int[] map = new int[26];
//        for (char c : S.toCharArray()) {
//            map[c - 'a']++;
//        }
//        Arrays.sort(map);
//        StringBuilder sb = new StringBuilder();
//        while (map[25] > 0) {
//            int i = 0;
//            while (i <= 1) {
//                if (map[25] == 0) {
//                    return sb.toString();
//                }
//                if (map[25 - i] > 0) {
//                    sb.append(map[25 - i]--);
//                } else {
//                    return "";
//                }
//            }
//            Arrays.sort(map);
//        }
//        return sb.toString();
//    }

    public String reorganizeString2(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (char c : map.keySet()) {
            queue.add(c);
        }
        while (!queue.isEmpty()) {
            int i = 0;
            List<Character> temp = new ArrayList<>();
            while (i <= 1) {
                if (temp.isEmpty() && queue.isEmpty()) {
                    return sb.toString();
                }
                if (queue.isEmpty()) {
                    return "";
                } else {
                    char c = queue.poll();
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) > 0) {
                        temp.add(c);
                    }
                }
                i++;
            }
            for (char s : temp) {
                queue.add(s);
            }
        }
        return sb.toString();
    }

    //这种方法是利用题目说的特征：相同字母不能相邻，所以在预先创建好的数组中隔一个位置插入某一个字符，数组填满后就是答案。如果某一个字母的数量超过了一半的值，则无法得到满足条件的结果

    public String reorganizeString3(String S) {
        int N = S.length();
        int[] map = new int[26];
        for (char c : S.toCharArray()) {
            map[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            map[i] += i;
        }                  //这里是在给每个数进行编码，100表示的是数量，i表示的是哪个字符，排序主要由数量来决定了
        Arrays.sort(map);

        char[] ans = new char[N];
        int i = 1;         //这里的i只能是1，不能是0，而排序是按照正序排的，也就是先处理少的，而当N是奇数时，奇数索引的单元格要少一些，可能不能应对多的字符，比如案例"aab"
        for (int num : map) {
            int count = num / 100;
            if (count > (N + 1) / 2) {
                return "";
            }
            for (int j = 0; j < count; j++) {
                if (i >= N) {
                    i = 0;
                }
                ans[i] = (char) ('a' + num % 100);
                i += 2;
            }
        }
        return String.valueOf(ans);
    }

    //方法4在方法2的基础上优化，先将不符合要求的返回掉，剩余符合要求的每次优先处理最多数量的字符
    public String reorganizeString4(String S) {
        int N = S.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (char c : map.keySet()) {
            if (map.get(c) > (N + 1) / 2) {
                return "";
            }
            queue.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() >= 2) {
            char c1 = queue.poll(), c2 = queue.poll();
            sb.append(c1).append(c2);
            if (map.get(c1) > 1) {
                map.put(c1, map.get(c1) - 1);
                queue.add(c1);
            }
            if (map.get(c2) > 1) {
                map.put(c2, map.get(c2) - 1);
                queue.add(c2);
            }
        }
        return queue.size() > 0 ? sb.append(queue.poll()).toString() : sb.toString();
    }

    public String reorganizeString5(String S) {
        int N = S.length();
        int[] map = new int[26];
        for (char c : S.toCharArray()) {
            map[c - 'a']++;
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map[o2 - 'a'] - map[o1 - 'a'];
            }
        });
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                if (map[i] > (N + 1) / 2) {
                    return "";
                }
                queue.add((char) ('a' + i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (queue.size() >= 2) {
            char c1 = queue.poll(), c2 = queue.poll();
            sb.append(c1).append(c2);
            if (map[c1 - 'a']-- > 1) {
                queue.add(c1);
            }
            if (map[c2 - 'a']-- > 1) {
                queue.add(c2);
            }
        }
        return queue.size() > 0 ? sb.append(queue.poll()).toString() : sb.toString();
    }

    public void test() {
        System.out.println(reorganizeString3("aabb"));
    }
}
