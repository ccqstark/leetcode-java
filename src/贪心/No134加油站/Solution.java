package 贪心.No134加油站;

public class Solution {

    /**
     * 解法1：暴力优化流（效果差）
     */
    public int canCompleteCircuit1(int[] gas, int[] cost) {

        int startIndex = 0;
        // 这里是为了过其中一个很多0的测试用例
        while (gas[startIndex] == 0) {
            startIndex++;
        }
        // 从头开始一个一个试
        for (int i = startIndex; i < gas.length; i++) {
            // 优化的地方，遇到连第一站都过不去都直接跳过
            if (gas[i] < cost[i]) {
                continue;
            }
            int remainGas = gas[i] - cost[i];
            int nowStep = i + 1 == gas.length ? 0 : i + 1;
            // 模拟这个过程，其中需要把超过数组长度的index转为0从头开始
            while (nowStep != i) {
                remainGas = remainGas + gas[nowStep] - cost[nowStep];
                if (remainGas < 0) {
                    break;
                }
                nowStep++;
                if (nowStep == gas.length) {
                    nowStep = 0;
                }
            }
            if (nowStep == i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 解法2：贪心法
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int curSum = 0; // 以当前start为起点的汽油结算
        int totalSum = 0; // 总汽油结算，即gas数组之和-cost数组之和
        int start = 0; // 起始点
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                // 如果在i位置遇到了剩余汽油为负数的情况，那说明在这之前的start都不行
                // 答案一定在i+1以及之后范围内
                start = i + 1;
                // 记得把curSum清空一下重新从新的start开始计算
                curSum = 0;
            }
        }
        // 如果总汽油都不够总消耗的话，那一定不行
        if (totalSum < 0) {
            return -1;
        }
        // 总汽油够的话，一定在某点有答案
        return start;
    }

}
