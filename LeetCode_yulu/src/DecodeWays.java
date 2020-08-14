import java.util.HashMap;

public class DecodeWays {
    //本题要注意0的字符，比如"0", "20123"
    //本题实际上就是字符串的解析方式，有几种解析方式就有几种decode方式
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        return decode(0, s, map);
    }

    public int decode(int index, String s, HashMap<Integer, Integer> map) {
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {  //任何以0开头的解析都是不合法的，因为0不能单独mapping
            return 0;
        }
        if (index == s.length() - 1) { //只剩一个字符时，肯定是合法的，但是这个顺序要注意，不能放到上一个if前面，因为当字符串就是"0"时，会出现错误的返回结果
            return 1;
        }
        if (map.containsKey(index)) {
            return map.get(index);  //用map保存结果可以降低时间复杂度，因为可能会存在重复的字符串，如果已经计算过就不会再次遍历了。
        }
        int count = decode(index + 1, s, map);
        if (Integer.valueOf(s.substring(index, index + 2)) <= 26) {
            count += decode(index + 2, s, map);
        }
        map.put(index, count);
        return count;
    }

   //动态规划，这里要注意如果开头为0，是无法解读的
    public int numDecodings2(String s) {
       int len = s.length();
       int[] dp = new int[len + 1];
       dp[0] = 1;
       dp[1] = s.charAt(0) == '0' ? 0 : 1;
       for (int i = 2; i <= len; i++) {
           //判断单个字符是否能解读
           if (s.charAt(i - 1) != '0') {
               dp[i] += dp[i - 1];
           }
           //判断两个字符是否能解读
           int num = Integer.parseInt(s.substring(i - 2, i));
           if (num >= 10 && num <= 26) {
               dp[i] += dp[i - 2];
           }
       }
       return dp[len];
    }

    public int numDecodings3(String s) {
        int len = s.length();
        int pre2 = 1, pre1 = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            int temp = 0;
            if (s.charAt(i) != '0') {
                temp += pre1;
            }
            int num = Integer.parseInt(s.substring(i - 1, i+ 1));
            if (num >= 10 && num <= 26) {
                temp += pre2;
            }
            pre2 = pre1;
            pre1 = temp;
        }
        return pre1;
    }

    public void test() {
        System.out.println(numDecodings3("226"));
    }
}
