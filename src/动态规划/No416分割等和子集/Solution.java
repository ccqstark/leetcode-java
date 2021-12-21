package 动态规划.No416分割等和子集;

public class Solution {

    public boolean canPartition(int[] nums) {
        // 题目限制了元素最大为100，数组数量最大为200，因此子集和最大为（100*200）/ 2 = 10000
        int[] dp = new int[10001];

        // 算出所有元素之和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 为奇数直接返回
        if (sum % 2 ==1){
            return false;
        }
        // 目标值就为所有元素之和的一半
        int target = sum / 2;

        // 这里写下自己的理解，为什么01背包可以用于这个问题的解决
        // 我们是在尽量找到和为sum的一半的元素集合是否存在，也就是说要尽量大，但是不能超过sum/2（也就是要刚好等于sum/2）
        // 1、而01背包的背包容量就是一个上限，限制了不能超过这个值
        // 2、而物品的价值就是一个我们希望尽可能大的值
        // 所以这两点特性刚好符合我们在解决这题目中需要的特点，所以可以套在01背包问题上
        // 因此物品的重量（被背包容量限制）和物品的价值（要尽量大）都该为nums[i]
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                dp[j] = Math.max(dp[j] , dp[j-nums[i]] + nums[i]);
            }
        }

        // 最后在目标值位置（背包容量上限位置），如果我们得到了目标值（最大价值），就说明找到了
        if (dp[target] == target){
            return true;
        }
        // 否则找不到
        return false;
    }

}
