import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new LinkedList<>();
        for (int n : stones) {
            list.add(n);
        }
        Collections.sort(list);
        while (list.size() > 1) {
            int m = list.get(list.size() - 2);
            int n = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.remove(list.size() - 1);
            if (m != n) {
                list.add(n - m);
            }
            Collections.sort(list);
        }
        return list.size() == 0 ? 0 : list.get(0);
    }
}
