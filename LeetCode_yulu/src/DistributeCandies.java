import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DistributeCandies {
    //edge case : [100000,0,100000,0,100000,0,100000,0,100000,0,100000,0]，[1,1,2,3】
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
        }
        return Math.min(candies.length / 2, set.size());
    }

    public int distributeCandies2(int[] candies) {
   //这里一定要注意先排序
        Arrays.sort(candies);
        int pre = Integer.MIN_VALUE, kinds = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] != pre) {
                pre = candies[i];
                kinds++;
            }
        }
        return Math.min(candies.length / 2, kinds);
    }
}
