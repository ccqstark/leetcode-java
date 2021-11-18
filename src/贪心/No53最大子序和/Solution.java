package 贪心.No53最大子序和;

public class Solution {
    public int maxSubArray(int[] nums) {

        int result = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 更新最大值
            if (sum > result){
                result = sum;
            }
            // 遇到负数就清空，因为负数对后面的结果只有负面效果
            if (sum < 0 ){
                sum = 0;
            }
        }

        return result;
    }
}
