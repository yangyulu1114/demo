import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        helper(candidates, ans, new LinkedList<>(), 0, target);
        return ans;
    }

    public void helper(int[] candidates, List<List<Integer>>ans, List<Integer> list, int index, int target) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            ans.add(new LinkedList<>(list));
            return;
        } else if (index >= candidates.length) {
            return;
        }
        list.add(candidates[index]);
        helper(candidates, ans, list, index, target - candidates[index]);
        list.remove(list.size() - 1);
        helper(candidates, ans, list, index + 1, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, ans, new ArrayList<>(), 0, target);
        return ans;
    }

    public void dfs(int[] candidates, List<List<Integer>> ans, List<Integer> list, int start, int target) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, ans, list, i, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
