package 综合.剑指Offer62圆圈中最后剩下的数字;

// 约瑟夫环，推过一次就行，以后会公式就行了（逃
public class Solution {
    public int lastRemaining(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
