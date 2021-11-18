package 贪心.No55跳跃游戏;

public class Solution {
    public boolean canJump(int[] nums) {
        int cover = 0; // 可以覆盖到的范围
        for (int i = 0; i <= cover; i++) {
            // 如果有更大的范围就更新
            if (i + nums[i] > cover) {
                cover = i + nums[i];
            }
            // 覆盖到数组最后一个
            if (cover >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
