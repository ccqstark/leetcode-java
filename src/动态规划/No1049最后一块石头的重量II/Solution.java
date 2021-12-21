package 动态规划.No1049最后一块石头的重量II;

/**
 * @author ccqstark
 * @description 这道题和No416分割等和子集很像，可以放一起看
 * @date 2021/12/22 01:22
 */
public class Solution {
    public int lastStoneWeightII(int[] stones) {

        // 这道题本质就是要把这堆石头尽量分成重量相差尽量小的两堆，那么就是尽量对半分
        // 那么就和分割等和子集有异曲同工之妙了

        // dp的长度同样是可能石头最大重量和的一半
        int[] dp = new int[1501];

        // 同样先求target，这里就是所有石头重量和的一半
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;

        // 同样的操作，这里就是为了逼近一半，因为分成2半尽可能一样重的话，肯定有一方小于等于总和的1/2，
        // 这里就是为了求小一点的那一半
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        // (sum - dp[target])就是另一半石头，他们差就是结果，如果为0就和等和子集一样啦
        return (sum - dp[target]) - dp[target];
    }
}
