package 贪心.No376摆动序列;

public class Solution {
    public int wiggleMaxLength(int[] nums) {

        if (nums.length <= 1) {
            return nums.length; // 数组长度为0和1的情况
        }

        int result = 1; // 初始化一个，因为后面算起伏数，而题目要的是子序列长度
        int preDiff = 0; // 上一个两元素之差
        int curDiff = 0; // 当前两元素之差

        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            // 只有preDiff可以为0，因为要考虑一开始前2个数还没有pre，所以看成多一个相同的数
            // 比如开头[1,2]可以看成[1,1,2]
            // 然后就是遇到起伏就+1
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                result++;
                // 移动pre，注意：如果遇到单调或水平的话，是不会移动pre的，它会与cur拉开距离
                preDiff = curDiff;
            }
        }

        return result;
    }
}
