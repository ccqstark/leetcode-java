package 贪心.No135分发糖果;

import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        // 从左到右，判断右边大的情况
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        // 从右到左，判断左边大的情况（原因：我们需要用到上一次比较的结果，反例[101,100,1]）
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                // 为了保证最后的糖果的花费最少，所以需要判断如果当前已经满足分数大的糖果多，就不用改变了
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
        }

        int sumCandy = 0;
        for (int i = 0; i < candy.length; i++) {
            sumCandy += candy[i];
        }
        return sumCandy;
    }
}
