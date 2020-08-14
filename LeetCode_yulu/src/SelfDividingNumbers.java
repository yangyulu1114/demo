import java.util.LinkedList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();

        for (int i = left; i <= right; i++) {
            int num = i;
            while (num != 0) {
                int tail = num % 10;
                if (tail == 0 || i % tail != 0) {
                    break;
                }
                num /= 10;
            }
            if (i != 0 && num == 0) {  //要注意i = 0的情况
                list.add(i);
            }
        }
        return list;
    }

    public void test() {
        List<Integer> list = selfDividingNumbers(1, 22);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
