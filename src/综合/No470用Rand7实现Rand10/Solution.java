package 综合.No470用Rand7实现Rand10;

/**
 * 最好的题解：https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/cong-zui-ji-chu-de-jiang-qi-ru-he-zuo-dao-jun-yun-/
 */
public class Solution {

    /**
     * 有一个知识点要清楚：
     * (rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数，即实现了 rand_XY()
     * 如果生成的范围超出了我们的期望，那么整数倍的情况下可以取余，不是整数倍的话我们就采用拒绝采样的方法
     */
    public int rand10() {
        // 死循环直到拿到想要的数为止
        while (true) {
            // 这里生成1-49，所以有9个数需要丢弃
            int num = (rand7() - 1) * 7 + rand7();
            // 如果刚好小于40，就取余+1后直接返回（+1是因为直接取余拿到的数[0,n-1]，我们要的是[1,n]）
            if (num <= 40) return num % 10 + 1;
            // 大于40的话就如下减去40再进行一次，相当于rand9，生成范围[1,63]，需要舍弃3个数
            num = (num - 40 - 1) * 7 + rand7();
            // 如果刚好小于60那可以直接返回
            if (num <= 60) return num % 10 + 1;
            // 大于60的话就如下减去60再进行一次，相当于rand3，生成范围[1,21]，只需要舍弃1个数
            num = (num - 60 - 1) * 7 + rand7();
            if (num <= 20) return num % 10 + 1;
        }
        // 进行这么多次重新调整范围是为了尽可能减少需要丢弃的个数，提高命中率
        // 如果不这样做直接重新开始一个循环也是可以，只不过效率较低
    }

    // 系统实现，此处不表
    public int rand7() {
        return 0;
    }
}
