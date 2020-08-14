import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minindex = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < list2.length; i++) {
           int index = map.getOrDefault(list2[i], -1);
           if (index >= 0) {
               int sum = index + i;
               if (sum == minindex) {
                   list.add(list2[i]);
               }
               if (sum < minindex) {
                   list.clear();
                   list.add(list2[i]);
                   minindex = sum;
               }
           }
        }
        return list.toArray(new String[list.size()]);
    }
}
