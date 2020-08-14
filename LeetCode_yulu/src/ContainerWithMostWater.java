public class ContainerWithMostWater {
    //本题要注意，1，一定要移动小的那一边，因为最大值是有短的那一边决定的，类似于木桶原理，另外即使右边相邻的那一边短一些，也不能放弃移动，因为后面有可能有更长的，所以要一直找到
    //start == end为止
    public int maxArea(int[] height) {
        int max = 0;
        for(int start = 0, end = height.length - 1; start < end;) {
            if (height[start] <= height[end]) {
                max = Math.max(max, (end - start) * height[start]);
                start++;
            } else {
                max = Math.max(max, (end - start) * height[end]);
                end--;
            }
        }
        return max;
    }
}
