package 位运算.剑指Offer15二进制中1的个数;

// 这题也就是求"汉明重量"
public class Solution {
    // 法1：逐位计数
    public int hammingWeight1(int n) {
        int cnt = 0;
        // int只有32位，所以循环32次即可
        for (int i = 0; i < 32; i++) {
            // 相当于把当前位以外的其他位都置为0，然后看当前位"与运算"之后整个数是否0来判断
            // 注意：也可能得出负数，所以不能用>0来判断
            if ((n & (1 << i)) != 0) {
                cnt++;
            }
        }

        return cnt;
    }

    // 法2（更优）：利用n&(n-1)是把n的最右边的那个1置为0的特性，例如：
    //   101000
    // & 100111
    // ---------
    //   100000
    public int hammingWeight2(int n) {
        int cnt = 0;
        // 当最终数为0的时候说明所有1都被去除了，结束计数
        while (n != 0) {
            n &= n - 1;
            cnt++;
        }
        return cnt;
    }
}
