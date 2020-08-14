import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            for (int j = 1; j < i; j++) {
                result.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            if (rowIndex > 0) {
                result.add(1);
            }
            list.add(result);
        }

        return list.get(rowIndex);
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>(), result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);
            for (int j = 1; j < i; j++) {
                result.add(list.get(j - 1) + list.get(j));
            }
            if (i > 0) {
                result.add(1);
            }

            list.clear();
            list.addAll(result);
            result.clear();
        }

        return list;
    }

    public List<Integer> getRow3(int rowIndex) {
        List<Integer> list = new ArrayList<>(), result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);
            for (int j = 1; j < i; j++) {
                result.add(list.get(j - 1) + list.get(j));
            }
            if (i > 0) {
                result.add(1);
            }

            list.clear();
            List<Integer> temp = list;
            list = result;
            result = temp;
        }

        return list;
    }

    public void test() {
        List<Integer> list = getRow3(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
