import java.util.LinkedList;
import java.util.List;

public class FindPositiveIntegerSolutionforaGivenEquation {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> list = new LinkedList<>();

        for (int i = 1; i <= 1000; i++) {
            findpairs(customfunction, list, i, z);
        }

        return list;
    }

    public void findpairs (CustomFunction customfunction, List<List<Integer>> list , int firstnumber, int z) {
        int i = 1, j = 1000;

        List<Integer> pair = new LinkedList<>();

        while (i <= j) {
            int mid = (i + j) / 2;
            if (customfunction.f(firstnumber, mid) > z) {
                j = mid -1;
            } else if (customfunction.f(firstnumber, mid) < z) {
                i = mid +1;
            } else {
                pair.add(firstnumber);
                pair.add(mid);
                break;
                //这里的break一定不要忘了加
            }
        }

        if (!pair.isEmpty()) {
            list.add(pair);
        }
    }
}
