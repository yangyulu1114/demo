import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), 1, n, k);
        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> list, int current, int n, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        } else if (current > n) {
            return;
        }

        list.add(current);
        helper(ans, list, current + 1, n, k);
        list.remove(list.size() - 1);

        helper(ans, list, current + 1, n, k);
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 1, n, k);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> list, int start, int n, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
        } else if (start > n) {
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(ans, list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }

    public void test() {
        List<List<Integer>> ans = combine2(4, 2);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
