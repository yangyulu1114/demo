import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, ans, new ArrayList<>(), 0, target);
        return ans;
    }

    public void helper(int[] candidates, List<List<Integer>> ans, List<Integer> list, int index, int target) {
        if (target < 0) {
            return;
        } else if (target == 0){
            ans.add(new ArrayList<>(list));
            return;
        } else if (index >= candidates.length) {
            return;
        }

        list.add(candidates[index]);
        helper(candidates, ans, list, index + 1, target - candidates[index]);
        list.remove(list.size() - 1);

        for(; index < candidates.length - 1 && candidates[index + 1] == candidates[index]; index++);
        helper(candidates, ans, list, index + 1, target);
    }

    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, ans, new ArrayList<>(), 0, target);
        return ans;
    }

    public void dfs(int[] candidates, List<List<Integer>> ans, List<Integer> list, int start, int target) {
        if (target < 0){
            return;
        } else if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, ans, list, i + 1, target - candidates[i]);
            list.remove(list.size() - 1);
            while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) {
                i++;
            }
        }
    }

    public void test() {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> ans = combinationSum2(candidates, 8);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
