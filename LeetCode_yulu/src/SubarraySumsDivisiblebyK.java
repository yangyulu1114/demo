import java.util.HashMap;

public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int remainder = 0,  count = 0;
        for (int i = 0; i < A.length; i++) {
            remainder += A[i];
            if (K != 0) {
                remainder %= K;
            }
            //这一步很关键，因为余数应该是为整数，但是%计算当被除数为负数时，余数可能会计算出负数
            if (remainder < 0) {
                remainder += K;
            }
            count += map.getOrDefault(remainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }

    public int subarraysDivByK2(int[] A, int K) {
        int[] remaindermap = new int[K]; //余数最大只有K - 1;
        remaindermap[0] = 1;
        int remainder = 0,  count = 0;
        for (int i = 0; i < A.length; i++) {
            remainder += A[i];
            if (K != 0) {
                remainder %= K;
            }
            //这一步很关键，因为余数应该是为整数，但是%计算当被除数为负数时，余数可能会计算出负数
            if (remainder < 0) {
                remainder += K;
            }
            count += remaindermap[remainder];
            remaindermap[remainder]++;
        }
        return count;
    }

    public void test() {
        int[] input = new int[]{4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(input, 5));
    }
}
