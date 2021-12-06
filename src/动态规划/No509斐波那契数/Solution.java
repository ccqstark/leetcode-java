package 动态规划.No509斐波那契数;

public class Solution {

    // 递归法，时间效率较差
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 动态规划
    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

}
