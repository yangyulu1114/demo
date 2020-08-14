public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len], R = new int[len], ans = new int[len];
        L[0] = 1;
        R[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--){
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }
//方法二比起方法1就是用ans先充当R，然后再依次乘上L
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            ans[i] = ans[i + 1] * nums[i + 1];
        }
        int left = nums[0];
        for (int i = 1; i < len; i++) {
            ans[i] *= left;
            left *= nums[i];
        }
        return ans;
    }
}
