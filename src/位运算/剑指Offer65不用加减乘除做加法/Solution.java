package 位运算.剑指Offer65不用加减乘除做加法;

public class Solution {
    /**
     * sum = 非进位和 + 进位
     */
    public int add(int a, int b) {
        // 不断循环，直到进位为0
        while (b != 0) {
            // 进位：与运算，左移一位
            int c = (a & b) << 1;
            // 非进位和：异或运算
            a = a ^ b;
            // 进位赋值给b，便于下一个循环继续重复相加操作
            b = c;
        }
        // 最后答案存储在a上
        return a;
    }
}
