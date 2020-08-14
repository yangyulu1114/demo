import java.util.HashSet;

public class FindtheDuplicateNumber {
//    edge case[2,2,2,2,2,2] ,所以这种方法不行，因为虽然有n+1个数都是在1和n之间，且只有一个重复的数，但是这个数可能会重复好多遍
//    public int findDuplicate(int[] nums) {
//        int number = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            number ^= nums[i];
//            number ^= (i + 1);
//        }
//        return number ^= nums[nums.length - 1];
//    }

    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return 0;
    }

//    本题可以模拟循环链表，通过num[i]的值指向链表的下一个node,num[i]作为index所在的元素就是下一个node，所以本题又转换为了找cycle link 的循环点，重复的这个数就是循环点。
// two pointers
    public int findDuplicate2(int[] nums) {
        int fastrunner = nums[0], slowrunner = nums[0];

        do {
            fastrunner = nums[nums[fastrunner]];
            slowrunner = nums[slowrunner];
        } while (fastrunner != slowrunner);

        for (slowrunner = nums[0]; slowrunner != fastrunner; slowrunner = nums[slowrunner], fastrunner = nums[fastrunner]) ;
        return fastrunner;
    }


    public void test() {
        int[] input = new int[] {1,3,4,2,2};
        System.out.println(findDuplicate2(input));
    }
}
