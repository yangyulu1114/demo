import java.util.ArrayList;
import java.util.List;
//本题要注意循环的退出条件，increment！= 0不能忘记

public class AddtoArrayFormofInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>();
        int increment = 0;
        for (int i = A.length - 1; i >= 0 || K != 0 || increment != 0; i--, K /= 10) {
            int a = i >= 0 ? A[i] : 0;
            int b = K % 10;
            int sum = a + b + increment;
            ans.add(0, sum % 10);
            increment = sum / 10;
        }
        return ans;
    }

    public void test() {
        int[] A = new int[]{2,7,4};
        List<Integer> ans = addToArrayForm(A, 181);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
