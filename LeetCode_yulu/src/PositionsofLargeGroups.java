import java.util.ArrayList;
import java.util.List;

public class PositionsofLargeGroups {
    //本题要注意最后一个字符与前面的字符组成largegroup的情况，例如edge case : "aaa"
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 1;
        for (int i = 1; i <= S.length(); i++) {
            if (i == S.length() || S.charAt(i) != S.charAt(i - 1)) {
                if (count >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i - count);
                    list.add(i - 1);
                    ans.add(list);
                }
                count = 1;
            }else {
                count++;
            }
        }
        return ans;
    }
}
