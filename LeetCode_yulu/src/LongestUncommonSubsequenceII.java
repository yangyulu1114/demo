public class LongestUncommonSubsequenceII {
    //这种方法没有考虑到特殊的case ["aaa","aaa","aa"]
//    public int findLUSlength(String[] strs) {
//        HashMap<String, Integer> map = new HashMap<>();
//        for(int i = 0; i < strs.length; i++) {
//            map.put(strs[i], map.getOrDefault(strs[i], 0) + 1);
//        }
//        int max = -1;
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                max = Math.max(max, entry.getKey().length());
//            }
//        }
//        return max;
//    }

    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            int j= 0;
            for (; j < strs.length; j++) {
                if (i != j && strs[j].indexOf(strs[i]) != -1) {
                    break;
                }
            }
            if (j >= strs.length) {
                max = Math.max(max, strs[i].length());
            }
        }
        return max;
    }

    public void test() {
        String[] input = new String[] {"aabbcc", "aabbcc","cb","abc"};
        System.out.println(findLUSlength(input));
    }
}
