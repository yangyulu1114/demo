import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class XofaKindinaDeckofCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : deck) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        boolean alleven = true, allequal = true;
        Integer pre = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pre != null && entry.getValue() != pre) {
                allequal = false;
            }
            if (entry.getValue() % 2 != 0) {
                alleven = false;
            }
            pre = entry.getValue();
        }
        return alleven || allequal;
    }

    public void test() {
        int[] deck = new int[]{1,1,1,2,2,2,3,3};
        System.out.println(hasGroupsSizeX(deck));
    }
}
