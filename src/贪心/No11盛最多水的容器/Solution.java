package 贪心.No11盛最多水的容器;

/**
 * 双指针：左右指针从头尾开始移动，每次移动那个较矮的，然后计算容积最后取最大
 * 为什么要每次移动较矮的那个？
 * 假设我们移动的是较高的那个，那么新的容器的高（也就是取决于当前左右位置中较低的那个）一定是小于等于旧的容器的高
 * 同时容器的宽也缩小了，也就是两指针之间的距离缩小了，那么乘出来的容积肯定变小了
 * 那么收缩高的那个指针得出来的水容积一定比当前的小，那么就应该去收缩那个矮的才可能得到更大的答案
 * 所以这是贪心的一个思想在里面
 */
public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxWater = 0;
        while (l < r) {
            maxWater = Math.max(maxWater, Math.min(height[l], height[r]) * (r - l));
            int i = height[l] <= height[r] ? ++l : --r;
        }
        return maxWater;
    }
}
