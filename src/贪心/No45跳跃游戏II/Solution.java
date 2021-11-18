package 贪心.No45跳跃游戏II;

/**
 * 核心在与让每一步尽量走到最远
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1){
            return 0;
        }
        int nowCover = 0; // 当前步覆盖的范围
        int nextCover = 0; // 下一步覆盖的范围
        int steps = 0; // 已经走的步数
        // 在本步范围内搜索下一步可以走到的最大范围
        for (int i = 0; i <= nowCover; i++) {
            // 更新下一步最大能覆盖的范围
            if (i + nums[i] > nextCover) {
                nextCover = i + nums[i];
            }
            // 到达本步的最大范围时
            if (i == nowCover) {
                steps++; // 走下一步
                nowCover = nextCover; // 更新本步范围
                if (nowCover >= nums.length - 1) { // 本步已经可以到达最后一个元素
                    return steps;  // 返回当前步数
                }
            }
        }
        return steps;
    }
}
