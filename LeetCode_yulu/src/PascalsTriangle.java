import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i - 1; j++) {
                list.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
            }
            if (i > 1) {
                list.add(1);
            }
            result.add(list);
            result.clear();
        }
        return result;
    }
}
