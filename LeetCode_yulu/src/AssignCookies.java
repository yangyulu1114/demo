import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = g.length - 1, j = s.length - 1; i >= 0 && j>= 0; i--) {
            if (g[i] <= s[j]) {
                count++;
                j--;
            }
        }
        return count;
    }

    public void test() {
        int[] g = new int[]{2, 2, 2};
        int[] s = new int[]{2,2,2};
        System.out.println(findContentChildren(g, s));
    }
}
