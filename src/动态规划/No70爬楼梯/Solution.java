package 动态规划.No70爬楼梯;

/**
 * @author ccqstark
 * @description 第n层楼梯的爬法数可以由第n-1和n-2层的爬法数之和所得，因为n-1就再爬一层，n-2就再爬两层（最后递推就是斐波那契数列）
 * @date 2021/12/6 22:08
 */
public class Solution {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // stairs[i]表示爬到第i层有多少种方法，因此i等于0时没有任何意义！
        int[] stairs = new int[n + 1];
        stairs[1] = 1;
        stairs[2] = 2;
        for (int i = 3; i <= n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }

        return stairs[n];
    }

    // 空间优化
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] stairs = new int[3];
        stairs[1] = 1;
        stairs[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = stairs[1] + stairs[2];
            stairs[1] = stairs[2];
            stairs[2] = sum;
        }

        return stairs[2];
    }

}
