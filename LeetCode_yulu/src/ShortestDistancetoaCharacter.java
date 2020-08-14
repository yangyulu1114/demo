import java.util.TreeSet;

public class ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                set.add(i);
            }
        }
        int[] ans = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                ans[i] = 0;
            } else {
                Integer left = set.floor(i);
                Integer right = set.ceiling(i);
                if (left == null) {
                    ans[i] = right - i;
                } else if (right == null) {
                    ans[i] = i - left;
                } else {
                    ans[i] = Math.min(right - i, i - left);
                }
            }
        }
        return ans;
    }

    public int[] shortestToChar2(String S, char C) {
        int[] ans = new int[S.length()];
        int pre = Integer.MIN_VALUE / 2;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                pre = i;
            }
            ans[i] = i - pre;
        }
        pre = Integer.MAX_VALUE;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                pre = i;
            }
            ans[i] = Math.min(ans[i], pre - i);
        }
        return ans;
    }

    public void test() {
        int[] output = shortestToChar("loveleetcode", 'e');
        for (int n : output) {
            System.out.println(n);
        }
    }
}
