package 数组.No238除自身以外数组的乘积;

/**
 * 思路是用一个数组L[]表示所有左边的乘积，一个数组R[]表示所有右边的乘积
 * 两者对应位置相乘就可以得到除了当前位置之外所有数的乘积
 * 为了达到空间复杂度为O(1)的优化（answer不算），可以让answer先当做L[]，再用一个变量代替R
 */
public class Solution {
    // 优化前
    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        L[0] = 1;
        R[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }

    // 优化后
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        // 用于表示右边数的乘积
        int R = nums[len - 1];
        // 此时的answer数组暂时表示的是左边所有数的乘积
        answer[0] = 1;
        for (int i = 1; i < len; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        // 用左边乘以右边，同时R不断向左扩张
        for (int i = len - 2; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        return answer;
    }
}
